package com.sevenine.conecta.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class CorsConfig {

    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = false
        config.addAllowedOrigin("*")
        config.addAllowedHeader("*")
        config.addAllowedMethod("POST")
        config.addAllowedMethod("GET")
        config.addAllowedMethod("PUT")
        config.addAllowedMethod("PATCH")
        config.addAllowedMethod("DELETE")
        source.registerCorsConfiguration("/**", config)
        return CorsFilter(source)
    }

}
