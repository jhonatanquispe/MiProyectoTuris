package com.example.demo.repository

import com.example.demo.model.Reserva
import org.springframework.data.jpa.repository.JpaRepository

interface ReservaRepository : JpaRepository<Reserva, Long>
