package com.example.demo.controller

import com.example.demo.model.User
import com.example.demo.repository.UserRepository
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userRepository: UserRepository // Inyectar el repositorio
) {

    @GetMapping("/me")
    fun getCurrentUser(@AuthenticationPrincipal user: UserDetails): ResponseEntity<User> {
        val currentUser = userRepository.findByEmail(user.username) // Obtener usuario por email
        return ResponseEntity.ok(currentUser) // Devolver datos del usuario
    }
}