package com.example.demo.service

import com.example.demo.dto.ReviewRequest
import com.example.demo.model.Review
import com.example.demo.repository.ReviewRepository
import org.springframework.stereotype.Service

@Service
class ReviewService(private val reviewRepository: ReviewRepository) {

    fun listarResenas(): List<Review> = reviewRepository.findAll()
    fun guardarResena(review: Review): Review = reviewRepository.save(review)
    fun obtenerResenaPorId(id: Long): Review? = reviewRepository.findById(id).orElse(null)
    fun eliminarResena(id: Long) = reviewRepository.deleteById(id)
    fun guardarResenaDesdeDto(reviewRequest: ReviewRequest): Review {
        val review = Review(
            comentario = reviewRequest.comentario,
            puntuacion = reviewRequest.puntuacion,
            usuario = reviewRequest.usuario
        )
        return reviewRepository.save(review)
    }
}
