package com.example.demo.controller

import com.example.demo.dto.LoginRequest
import com.example.demo.dto.RegisterRequest
import com.example.demo.service.AuthService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth") // Ruta corregida
class AuthController(
    private val authService: AuthService // Inyección de dependencia
) {

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): ResponseEntity<Map<String, String>> {
        return try {
            val user = authService.register(request.name, request.email, request.password)
            ResponseEntity.ok(
                mapOf(
                    "message" to "Usuario registrado exitosamente",
                    "userId" to user.id.toString(),
                    "email" to user.email
                )
            )
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(mapOf("error" to (e.message ?: "Error en el registro")))
        }
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Map<String, String>> {
        return try {
            val token = authService.login(request.email, request.password)
            ResponseEntity.ok(mapOf("token" to token))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(mapOf("error" to "Credenciales inválidas"))
        }
    }

    @GetMapping("/me") // Nuevo endpoint para obtener datos del usuario
    fun getCurrentUser(): ResponseEntity<Map<String, String>> {
        // Implementar lógica para obtener usuario autenticado
        return ResponseEntity.ok(mapOf("name" to "Usuario Ejemplo", "email" to "ejemplo@test.com"))
    }
}
