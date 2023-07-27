package com.example.graphqlmsn.Model.errorModel

data class Error(
    val extensions: Extensions,
    val message: String,
    val path: List<String>
)