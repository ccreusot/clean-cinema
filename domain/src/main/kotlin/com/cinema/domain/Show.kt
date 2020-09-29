package com.cinema.domain

data class Show(
        val id: Int,
        val title: String,
        val startTime: Long
)

data class ShowDetails(
        val id: Int,
        val title: String,
        val startTime: Long,
        val description: String,
        val director: String,
        val image: String,
        val actors: List<String>
)

sealed class BookingStatus {
    object Success : BookingStatus()
    data class Failure(val message: String) : BookingStatus()
}
