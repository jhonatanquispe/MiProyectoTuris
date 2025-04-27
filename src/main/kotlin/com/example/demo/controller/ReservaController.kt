package com.example.demo.controller

import com.example.demo.service.ReservaService
import org.springframework.web.bind.annotation.*
import com.example.demo.model.Reserva
import com.example.demo.model.ReservaRequest

@RestController
@RequestMapping("/api/reservas")
class ReservaController(private val reservaService: ReservaService) {

    @PostMapping
    fun crearReserva(@RequestBody reservaRequest: ReservaRequest): Reserva {
        return reservaService.crearReserva(
            reservaRequest.hotelId,
            reservaRequest.habitacionId,
            reservaRequest.fechaEntrada,
            reservaRequest.fechaSalida
        )
    }
}
