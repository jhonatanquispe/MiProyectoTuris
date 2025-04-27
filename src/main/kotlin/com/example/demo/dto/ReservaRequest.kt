package com.example.demo.model

data class ReservaRequest(
    val hotelId: Long,
    val habitacionId: Long,
    val fechaEntrada: String,
    val fechaSalida: String
)
