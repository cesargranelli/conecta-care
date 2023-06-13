package com.sevenine.usuario.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//import com.sevenine.conecta.configs.properties.SecurityProperties;
//import com.sevenine.conecta.http.data.request.CadastroUsuarioRequest;
//import com.sevenine.conecta.repository.data.Usuario;
//import com.sevenine.conecta.security.AuthenticationFilter;
//import com.sevenine.conecta.security.AuthorizarionFilter;
//import com.sevenine.conecta.service.BuscaStatusCadastroService;
//import com.sevenine.conecta.service.GeneratedTokenService;
//import com.sevenine.conecta.service.ValidaCadastroAtivoService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
public class SecurityConfiguration /*extends WebSecurityConfigurerAdapter*/ {
    //
//    private final SecurityProperties securityProperties;
//
//    @Qualifier("UsuarioConverter")
//    private final Converter<CadastroUsuarioRequest, Usuario> usuarioConverter;
//
//    private final GeneratedTokenService generatedTokenService;
//    private final ValidaCadastroAtivoService validaCadastroAtivoService;
//    private final BuscaStatusCadastroService buscaStatusCadastroService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//                .authorizeRequests()
//                .antMatchers(
//                        this.securityProperties.getEndpointAtivacao(),
//                        this.securityProperties.getSignUpUrl(),
//                        "/actuator/**"
//                )
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new AuthenticationFilter(securityProperties, authenticationManager(), usuarioConverter, generatedTokenService, validaCadastroAtivoService, buscaStatusCadastroService))
//                .addFilter(new AuthorizarionFilter(this.securityProperties, authenticationManager()))
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//
    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeHttpRequests(authorize -> authorize
//                .mvcMatchers("/**").permitAll()
                .anyRequest().authenticated());

        return http.getOrBuild();
    }

}
