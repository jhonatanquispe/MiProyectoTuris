package com.example.demo.dto

data class ReviewRequest(
    val comentario: String,
    val puntuacion: Int,
    val usuario: String
)
