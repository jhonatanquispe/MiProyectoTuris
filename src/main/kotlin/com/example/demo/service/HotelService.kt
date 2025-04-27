package com.example.demo.service

import com.example.demo.model.Hotel
import com.example.demo.repository.HotelRepository
import org.springframework.stereotype.Service

@Service
class HotelService(private val hotelRepository: HotelRepository) {

    fun crearHotel(hotel: Hotel): Hotel = hotelRepository.save(hotel)

    fun obtenerHoteles(): List<Hotel> = hotelRepository.findAll()

    fun obtenerHotelPorId(id: Long): Hotel =
        hotelRepository.findById(id).orElseThrow { RuntimeException("Hotel no encontrado") }

    fun actualizarHotel(id: Long, hotelActualizado: Hotel): Hotel {
        val hotel = obtenerHotelPorId(id)
        val actualizado = hotel.copy(
            nombre = hotelActualizado.nombre,
            ubicacion = hotelActualizado.ubicacion,
            descripcion = hotelActualizado.descripcion,
            disponible = hotelActualizado.disponible
        )
        return hotelRepository.save(actualizado)
    }

    fun eliminarHotel(id: Long) = hotelRepository.deleteById(id)
}
