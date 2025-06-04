package ru.user.domain.api

interface UserApiClient {

    fun findUserById(id: String): User?

}