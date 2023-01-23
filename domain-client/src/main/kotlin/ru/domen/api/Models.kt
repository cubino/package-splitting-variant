package ru.domen.api

data class FullEntity(
    val id: String,
    val field: String,
    val version: Int
)

data class ShortEntity(
    val id: String,
    val field: String,
)