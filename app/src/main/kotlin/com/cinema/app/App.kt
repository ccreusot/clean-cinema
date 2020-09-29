/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.cinema.app

import com.cinema.domain.Show
import com.cinema.domain.ShowListInteractor
import com.cinema.domain.ShowListPresenter
import com.cinema.domain.repositories.ShowsRepository
import com.cinema.domain.usecases.CinemaShowsOfTheDayUseCase


fun main() {
    val showListInteractor = ShowListInteractor(
            usecase = CinemaShowsOfTheDayUseCase(
                    repository = MockShowsRepository()
            ),
            presenter = ConsoleShowListPresenter(ConsoleShowListView())
    )
    showListInteractor.fetch()
}

data class ShowViewModel(
        val title: String,
        val startTime: Long
)

interface ShowListView {
    fun displayLoading()
    fun displayList(shows: List<ShowViewModel>)
}

class ConsoleShowListView : ShowListView {
    override fun displayLoading() {
        println("Loading...")
    }

    override fun displayList(shows: List<ShowViewModel>) {
        shows.forEach(::println)
    }
}

class ConsoleShowListPresenter(private val view: ShowListView) : ShowListPresenter {
    override fun presentLoading() {
        view.displayLoading()
    }

    override fun presentShowList(shows: List<Show>) {
        view.displayList(shows.map {
            ShowViewModel(it.title, it.startTime)
        })
    }
}

class MockShowsRepository : ShowsRepository {
    override fun fetch(): List<Show> = listOf(
            Show(0, "Matrix", 117),
            Show(1, "OSS", 4001),
            Show(2, "Kaamelott", 111701895),
    )
}
