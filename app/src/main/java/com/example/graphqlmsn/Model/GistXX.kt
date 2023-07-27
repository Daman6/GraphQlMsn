package com.example.graphqlmsn.Model

data class GistXX(
    val contentType: String,
    val description: String,
    val featuredTag: FeaturedTagXX,
    val id: String,
    val imageGist: ImageGistXX,
    val languageCode: String,
    val permalink: String,
    val primaryCategory: PrimaryCategoryXX,
    val scheduleEndDate: Any,
    val scheduleStartDate: Any,
    val site: String,
    val timezone: String,
    val title: String
)