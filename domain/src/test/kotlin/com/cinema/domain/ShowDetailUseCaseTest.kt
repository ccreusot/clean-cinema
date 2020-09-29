package com.cinema.domain

import com.cinema.domain.repositories.ShowDetailsRepository
import com.cinema.domain.usecases.ShowDetailUseCase
import org.junit.Test
import kotlin.test.assertEquals

class ShowDetailUseCaseTest {
    @Test
    fun `get show detail by id`() {
        // Given
        val expectedShowDetails = ShowDetails(
                id = 0,
                title = "title",
                startTime = 20L,
                description = "description",
                director = "director",
                image = "image",
                actors = listOf("actor1", "actor2", "actor3")
        )
        val repository: ShowDetailsRepository = object : ShowDetailsRepository {
            override fun getShowDetails(showId: Int) = expectedShowDetails
        }

        // When
        val details = ShowDetailUseCase(repository, Show(id = 0, title = "titre", startTime = 20L)).getShowDetails()

        // Then
        assertEquals(expectedShowDetails, details)
    }
}