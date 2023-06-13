//package com.sevenine.conecta.security;
//
//import com.sevenine.conecta.configs.properties.SecurityProperties;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Objects;
//
//import static com.sevenine.conecta.configs.SecurityConstants.HEADER_NAME;
//import static com.sevenine.conecta.configs.SecurityConstants.HEADER_PREFIX;
//import static java.util.Objects.nonNull;
//
//public class AuthorizarionFilter extends BasicAuthenticationFilter {
//
//    private final SecurityProperties securityProperties;
//
//    public AuthorizarionFilter(SecurityProperties securityProperties, AuthenticationManager authenticationManager) {
//        super(authenticationManager);
//        this.securityProperties = securityProperties;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        String header = request.getHeader(HEADER_NAME);
//
//        if (Objects.isNull(header)) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = authenticate(request);
//
//        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//        chain.doFilter(request, response);
//    }
//
//    private UsernamePasswordAuthenticationToken authenticate(HttpServletRequest request) {
//        String token = request.getHeader(HEADER_NAME);
//
//        if (nonNull(token) && !token.isEmpty()) {
//            Claims user = Jwts.parserBuilder()
//                    .setSigningKey(Keys.hmacShaKeyFor(securityProperties.getKey().getBytes()))
//                    .build()
//                    .parseClaimsJws(token.replaceFirst(HEADER_PREFIX, ""))
//                    .getBody();
//
//            if (nonNull(user)) {
//                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//            } else {
//                return null;
//            }
//        }
//
//        return null;
//    }
//}
