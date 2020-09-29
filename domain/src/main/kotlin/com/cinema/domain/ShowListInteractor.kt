package com.cinema.domain

import com.cinema.domain.usecases.CinemaShowsOfTheDayUseCase

class ShowListInteractor(private val usecase: CinemaShowsOfTheDayUseCase,
                         private val presenter: ShowListPresenter) {
    fun fetch() {
        presenter.presentLoading()
        presenter.presentShowList(usecase.getShows())
    }
}