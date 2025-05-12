package com.example.zomato.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/customer/login",
                        "/register",
                        "/swagger-ui.html",                      // old style path
                        "/swagger-ui/**",                        // new UI assets
                        "/v3/api-docs/**",                       // OpenAPI JSON
                        "/swagger-resources/**",                 // Swagger UI support
                        "/webjars/**",                           // Swagger CSS/JS
                        "/csrf"                                  // CSRF path if enabled
                );
    }

}
