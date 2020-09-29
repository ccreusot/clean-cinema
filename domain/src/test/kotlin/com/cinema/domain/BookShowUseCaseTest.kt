package com.cinema.domain

import com.cinema.domain.repositories.BookingRepository
import com.cinema.domain.usecases.BookShowUseCase
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BookShowUseCaseTest {
    private val mockShowDetails = ShowDetails(
            id = 0,
            title = "title",
            startTime = 20L,
            description = "description",
            director = "director",
            image = "image",
            actors = listOf("actor1", "actor2", "actor3")
    )

    private fun mockRepository(bookingStatusWanted: BookingStatus) = object : BookingRepository {
        override fun bookShow(showId: Int): BookingStatus = bookingStatusWanted
    }

    @Test
    fun `book show`() {
        val repository = mockRepository(BookingStatus.Success)

        val booking = BookShowUseCase(repository, mockShowDetails).book()

        assertTrue(booking is BookingStatus.Success)
    }

    @Test
    fun `booking failure`() {
        val expectedBooking = BookingStatus.Failure("error message")
        val repository = mockRepository(expectedBooking)

        val booking = BookShowUseCase(repository, mockShowDetails).book()

        assertTrue(booking is BookingStatus.Failure)
        assertEquals(expectedBooking, booking)
    }
}