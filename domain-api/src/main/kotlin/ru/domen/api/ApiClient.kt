package ru.domen.api

interface ApiClient {

    fun getFullEntity(id: String): FullEntityResponse

    fun getShortEntity(id: String): ShortEntityResponse

    fun deleteEntity(id: String)

}