package com.cinema.domain.usecases

import com.cinema.domain.Show
import com.cinema.domain.ShowDetails
import com.cinema.domain.repositories.ShowDetailsRepository

class ShowDetailUseCase(private val repository: ShowDetailsRepository, private val show: Show) {
    fun getShowDetails(): ShowDetails = repository.getShowDetails(show.id)
}