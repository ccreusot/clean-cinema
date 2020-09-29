package com.cinema.domain

import com.cinema.domain.repositories.ShowsRepository
import com.cinema.domain.usecases.CinemaShowsOfTheDayUseCase
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


internal class CinemaShowsOfTheDayUseCaseTest {
    @Test
    internal fun `fetch shows of the day`() {
        // Given
        val showsMocked = listOf(
                Show(0, "title", 10L),
                Show(2, "title", 30L),
                Show(1, "title", 20L)
        )
        val showsExpected = listOf(
                Show(0, "title", 10L),
                Show(1, "title", 20L),
                Show(2, "title", 30L)
        )
        val repository: ShowsRepository = object : ShowsRepository {
            override fun fetch(): List<Show> = showsMocked
        }

        val useCase = CinemaShowsOfTheDayUseCase(repository)

        // When
        val shows = useCase.getShows()
        // Then
        assertEquals(showsExpected, shows)
        assertTrue(shows.isNotEmpty())
    }
}