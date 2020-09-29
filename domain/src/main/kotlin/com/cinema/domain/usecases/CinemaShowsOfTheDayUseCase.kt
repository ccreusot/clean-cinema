package com.cinema.domain.usecases

import com.cinema.domain.Show
import com.cinema.domain.repositories.ShowsRepository

class CinemaShowsOfTheDayUseCase(private val repository: ShowsRepository) {
    fun getShows(): List<Show> = repository.fetch().sortedBy {
        it.startTime
    }
}