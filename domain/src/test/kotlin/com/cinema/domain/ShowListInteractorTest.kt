package com.cinema.domain

import com.cinema.domain.repositories.ShowsRepository
import com.cinema.domain.usecases.CinemaShowsOfTheDayUseCase
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Test

class ShowListInteractorTest {
    @Test
    fun `fetch show list`() {
        val list = listOf(Show(0, "title", 10L))
        val repository = object : ShowsRepository {
            override fun fetch(): List<Show> {
                return list
            }
        }
        val usecase = spyk(CinemaShowsOfTheDayUseCase(repository))
        val presenter = mockk<ShowListPresenter>(relaxed = true)

        val interactor = ShowListInteractor(usecase, presenter)

        interactor.fetch()

        verify { presenter.presentLoading() }
        verify { usecase.getShows() }
        verify { presenter.presentShowList(list) }
    }
}