package com.example.graphqlmsn.Model

data class GistX(
    val contentType: String,
    val description: String,
    val featuredTag: FeaturedTag,
    val id: String,
    val imageGist: ImageGistX,
    val languageCode: String,
    val permalink: String,
    val scheduleEndDate: Any,
    val scheduleStartDate: Any,
    val site: String,
    val timezone: Any,
    val title: String
)