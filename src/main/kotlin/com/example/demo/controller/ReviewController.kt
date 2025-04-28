package com.example.demo.controller

import com.example.demo.dto.ReviewRequest
import com.example.demo.model.Review
import com.example.demo.service.ReviewService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/reviews")
class ReviewController(private val reviewService: ReviewService) {

    @GetMapping
    fun obtenerTodas(): List<Review> = reviewService.listarResenas()

    @PostMapping
    fun crear(@RequestBody review: Review): Review = reviewService.guardarResena(review)

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long): Review? = reviewService.obtenerResenaPorId(id)

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Long) = reviewService.eliminarResena(id)

    @PostMapping
    fun crear(@RequestBody reviewRequest: ReviewRequest): Review =
        reviewService.guardarResenaDesdeDto(reviewRequest)
}
