package ru.user.domain.api

data class User(
    val id: String,
    val name: String,
    val email: String,
    val isEnabled: Boolean
)