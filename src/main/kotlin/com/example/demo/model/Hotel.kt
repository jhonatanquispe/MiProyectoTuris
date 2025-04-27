package com.example.demo.model

import jakarta.persistence.*

@Entity
data class Hotel(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val nombre: String,
    val ubicacion: String,
    val descripcion: String,
    val disponible: Boolean = true
)
