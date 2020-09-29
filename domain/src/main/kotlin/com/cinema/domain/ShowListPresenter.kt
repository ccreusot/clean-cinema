package com.cinema.domain

interface ShowListPresenter {
    fun presentLoading()
    fun presentShowList(shows: List<Show>)
}
