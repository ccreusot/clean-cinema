package com.cinema.domain.repositories

import com.cinema.domain.BookingStatus

interface BookingRepository {
    fun bookShow(showId: Int): BookingStatus
}