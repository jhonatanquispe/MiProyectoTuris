package com.example.demo.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Reserva(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val hotelId: Long,
    val habitacionId: Long,
    val fechaEntrada: LocalDate,
    val fechaSalida: LocalDate
)
