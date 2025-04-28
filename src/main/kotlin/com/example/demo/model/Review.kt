package com.example.demo.model

import jakarta.persistence.*

@Entity
@Table(name = "reviews")
data class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val comentario: String = "",

    val puntuacion: Int = 0,

    val usuario: String = ""
)
