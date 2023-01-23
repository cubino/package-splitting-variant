package ru.domain

data class InternalModel(
    val id: String,
    val field: String,
    val version: Int,
    val createdByUserId: String,
    val modifiedByUserId: String
)