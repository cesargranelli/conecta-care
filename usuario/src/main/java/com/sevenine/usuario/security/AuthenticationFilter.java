//package com.sevenine.conecta.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sevenine.conecta.configs.properties.SecurityProperties;
//import com.sevenine.conecta.entity.TokenResponseBody;
//import com.sevenine.conecta.enumerator.StatusCadastro;
//import com.sevenine.conecta.exception.CadastroIncompletoException;
//import com.sevenine.conecta.http.data.request.CadastroUsuarioRequest;
//import com.sevenine.conecta.http.data.request.LoginUsuarioRequest;
//import com.sevenine.conecta.repository.data.Usuario;
//import com.sevenine.conecta.service.BuscaStatusCadastroService;
//import com.sevenine.conecta.service.GeneratedTokenService;
//import com.sevenine.conecta.service.ValidaCadastroAtivoService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static java.util.Collections.emptyList;
//
//@Log4j2
//@RequiredArgsConstructor
//public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private final SecurityProperties securityProperties;
//    private final AuthenticationManager authenticationManager;
//    private final ObjectMapper objectMapper = new ObjectMapper();
//    private final Converter<CadastroUsuarioRequest, Usuario> usuarioRequestConverter;
//    private final GeneratedTokenService generatedTokenService;
//    private final ValidaCadastroAtivoService validaCadastroAtivoService;
//    private final BuscaStatusCadastroService buscaStatusCadastroService;
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        try {
//            final LoginUsuarioRequest loginUsuarioRequest = objectMapper.readValue(request.getInputStream(), LoginUsuarioRequest.class);
//
//            validaCadastroAtivoService.validar(loginUsuarioRequest.getEmail(), loginUsuarioRequest.getModulo());
//
//            request.setAttribute("modulo", loginUsuarioRequest.getModulo());
//
//            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                    new UsernamePasswordAuthenticationToken(loginUsuarioRequest.getEmail(), loginUsuarioRequest.getPassword(), emptyList());
//
//            log.info(String.format("Autenticação do usuário: %s", loginUsuarioRequest.getEmail()));
//
//            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
//
//            if (!temRoleInformada(authentication, loginUsuarioRequest)) {
//                throw new RuntimeException(String.format("Usuário %s não possui role informada", loginUsuarioRequest.getEmail()));
//            }
//
//            return authentication;
//        } catch (AuthenticationException exception) {
//            log.error("Falha ao autenticar o usuário: ".concat(exception.getLocalizedMessage()));
//            throw exception;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
//                                            FilterChain chain, Authentication authResult) throws IOException {
//
//        User principal = (User) authResult.getPrincipal();
//        List<String> roles = principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
//        String token = generatedTokenService.retrieveToken(principal.getUsername(), roles, request.getAttribute("modulo").toString());
//
//        PrintWriter responseBody = response.getWriter();
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.setCharacterEncoding("UTF-8");
//
//        log.info(String.format("Usuario %s autenticado com sucesso.", principal.getUsername()));
//
//        StatusCadastro statusCadastro = buscaStatusCadastroService.validar(principal.getUsername(), request.getAttribute("modulo").toString());
//
//        TokenResponseBody tokenResponseBody = new TokenResponseBody(token, securityProperties.getExpirationTime(), "A SER IMPLEMENTADO", statusCadastro);
//        responseBody.print(this.objectMapper.writeValueAsString(tokenResponseBody));
//        responseBody.flush();
//
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {
//        if (failed instanceof CadastroIncompletoException) {
//            response.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED);
//        } else {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        }
//    }
//
//    private boolean temRoleInformada(Authentication usuarioAuthentication, LoginUsuarioRequest loginUsuarioRequest) {
//        List<String> rolesAssociadasAoUsuario = getRolesAssociadasAoUsuario(usuarioAuthentication.getAuthorities());
//
//        for (String roleAssociadaAoUsuario : rolesAssociadasAoUsuario) {
//            if (roleAssociadaAoUsuario.equals("ROLE_" + loginUsuarioRequest.getModulo())) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    private List<String> getRolesAssociadasAoUsuario(Collection<? extends GrantedAuthority> grantedAuthorityColletion) {
//        return grantedAuthorityColletion
//                .stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList());
//    }
//}
