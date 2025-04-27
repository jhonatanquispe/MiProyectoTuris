package com.example.demo.security // ¡Debe coincidir con la estructura!
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import java.security.Key
import java.util.*

@Service
class JwtService {
    private val secretKey: Key = Keys.secretKeyFor(SignatureAlgorithm.HS256)
    private val expirationTime: Long = 86400000 // 24 horas

    fun generateToken(userId: Long, role: String): String {
        return Jwts.builder()
            .setSubject(userId.toString())
            .claim("role", role)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expirationTime))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact()
    }

    fun validateToken(token: String): Claims {
        return Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(token) // ¡Aquí!
            .body
    }
}