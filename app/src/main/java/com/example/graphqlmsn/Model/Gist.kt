package com.example.graphqlmsn.Model

data class Gist(
    val contentType: String,
    val description: Any,
    val featuredTag: FeaturedTag,
    val id: String,
    val imageGist: ImageGist,
    val languageCode: String,
    val permalink: String,
    val primaryCategory: PrimaryCategory,
    val scheduleEndDate: Any,
    val scheduleStartDate: Any,
    val site: String,
    val timezone: Any,
    val title: String
)