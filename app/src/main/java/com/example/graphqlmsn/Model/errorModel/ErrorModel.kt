package com.example.graphqlmsn.Model.errorModel

data class ErrorModel(
    val `data`: Any,
    val errors: List<Error>
)