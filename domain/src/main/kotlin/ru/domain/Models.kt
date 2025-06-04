package ru.domain

internal data class InternalEntityModel(
    val id: String,
    val field: String,
    val version: Int,
    val createdByUserId: String,
    val modifiedByUserId: String
)

internal data class InternalUserModel(
    val id: String,
    val name: String,
    val email: String
)
