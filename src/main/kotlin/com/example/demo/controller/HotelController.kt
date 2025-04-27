package com.example.demo.controller

import com.example.demo.model.Hotel
import com.example.demo.service.HotelService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/hoteles")
class HotelController(private val hotelService: HotelService) {

    @PostMapping
    fun crear(@RequestBody hotel: Hotel): Hotel = hotelService.crearHotel(hotel)

    @GetMapping
    fun listar(): List<Hotel> = hotelService.obtenerHoteles()

    @GetMapping("/{id}")
    fun obtener(@PathVariable id: Long): Hotel = hotelService.obtenerHotelPorId(id)

    @PutMapping("/{id}")
    fun actualizar(@PathVariable id: Long, @RequestBody hotel: Hotel): Hotel =
        hotelService.actualizarHotel(id, hotel)

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Long) = hotelService.eliminarHotel(id)
}

