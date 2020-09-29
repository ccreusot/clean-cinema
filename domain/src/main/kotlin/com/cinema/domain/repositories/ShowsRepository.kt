package com.cinema.domain.repositories

import com.cinema.domain.Show

interface ShowsRepository {
    fun fetch(): List<Show>

}
