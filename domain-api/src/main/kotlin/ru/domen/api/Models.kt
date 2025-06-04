package ru.domen.api

data class FullEntityResponse(
    val id: String,
    val field: String,
    val version: Int,
    val owner: OwnerResponse?
)

data class ShortEntityResponse(
    val id: String,
    val field: String
)

data class OwnerResponse(
    val id: String,
    val name: String
)