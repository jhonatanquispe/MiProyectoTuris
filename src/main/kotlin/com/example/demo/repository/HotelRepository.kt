package com.example.demo.repository

import com.example.demo.model.Hotel
import org.springframework.data.jpa.repository.JpaRepository

interface HotelRepository : JpaRepository<Hotel, Long>
