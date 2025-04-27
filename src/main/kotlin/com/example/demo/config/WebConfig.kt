package com.example.demo.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    // Configuración global para todos los endpoints
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")  // Aplica a todas las rutas
            .allowedOrigins("*")    // Permite cualquier origen (¡cambia esto en producción!)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .exposedHeaders("Authorization") // Headers que el frontend puede leer
            .allowCredentials(false) // Para desarrollo, en producción usa true si necesitas cookies
            .maxAge(3600) // Tiempo de cache para la configuración CORS
    }
}