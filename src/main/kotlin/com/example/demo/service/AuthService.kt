package com.example.demo.service

import com.example.demo.model.User
import com.example.demo.repository.UserRepository
import com.example.demo.security.JwtService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService
) {
    fun register(name: String, email: String, password: String): User {
        if (userRepository.findByEmail(email) != null) {
            throw RuntimeException("El correo ya está registrado")
        }
        val user = User(
            name = name,
            email = email,
            encodedPassword = passwordEncoder.encode(password) // ¡Aquí!
         )
        return userRepository.save(user)
    }

    fun login(email: String, password: String): String {
        val user = userRepository.findByEmail(email) ?: throw RuntimeException("Usuario no encontrado")
        if (!passwordEncoder.matches(password, user.encodedPassword)) { // ¡Aquí!
            throw RuntimeException("Contraseña incorrecta")
        }
        return jwtService.generateToken(user.id, user.role)
    }
}