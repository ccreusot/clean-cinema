package com.cinema.domain.usecases

import com.cinema.domain.repositories.BookingRepository
import com.cinema.domain.BookingStatus
import com.cinema.domain.ShowDetails

class BookShowUseCase(private val repository: BookingRepository, private val showDetails: ShowDetails) {
    fun book(): BookingStatus = repository.bookShow(showId = showDetails.id)
}