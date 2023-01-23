package ru.consumer.dataprovider

import ru.domen.api.ApiClient
import ru.domen.api.ShortEntity

internal typealias InternalEntity = ShortEntity

internal class EntityDataProvider(
    private val entityApiClient: ApiClient
) {

    fun getEntityById(id: String): InternalEntity {
        return entityApiClient.getShortEntity(id)
    }

}