package com.example.graphqlmsn.Model

data class GameSchedule(
    val items: List<Item>,
    val limit: Int,
    val offset: Int
)