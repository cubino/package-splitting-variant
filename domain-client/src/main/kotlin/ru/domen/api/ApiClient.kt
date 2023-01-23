package ru.domen.api

interface ApiClient {

    fun getFullEntity(id: String): FullEntity

    fun getShortEntity(id: String): ShortEntity

}