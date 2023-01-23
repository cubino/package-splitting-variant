package ru.domain.entrypoint

import ru.domain.usecase.GetFullEntity
import ru.domain.usecase.GetShortEntity
import ru.domen.api.ApiClient
import ru.domen.api.FullEntity
import ru.domen.api.ShortEntity

internal class EntityEmbeddedServer(
    private val getFullEntity: GetFullEntity,
    private val getShortEntity: GetShortEntity
) : ApiClient {

    override fun getFullEntity(id: String): FullEntity {
        return getFullEntity(id)
    }

    override fun getShortEntity(id: String): ShortEntity {
        return getShortEntity(id)
    }

}