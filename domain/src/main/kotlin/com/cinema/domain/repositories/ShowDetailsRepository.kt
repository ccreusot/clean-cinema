package com.cinema.domain.repositories

import com.cinema.domain.ShowDetails

interface ShowDetailsRepository {

    fun getShowDetails(showId: Int): ShowDetails
}
