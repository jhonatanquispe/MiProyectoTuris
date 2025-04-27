package com.example.demo.service

import com.example.demo.model.Reserva
import com.example.demo.repository.ReservaRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ReservaService(private val reservaRepository: ReservaRepository) {

    fun crearReserva(hotelId: Long, habitacionId: Long, fechaEntrada: String, fechaSalida: String): Reserva {
        val reserva = Reserva(
            hotelId = hotelId,
            habitacionId = habitacionId,
            fechaEntrada = LocalDate.parse(fechaEntrada),
            fechaSalida = LocalDate.parse(fechaSalida)
        )
        return reservaRepository.save(reserva)
    }
}
