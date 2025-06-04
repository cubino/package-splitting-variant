package ru.domain.usecase

import ru.domain.InternalEntityModel
import ru.domain.dataprovider.EntityDataProvider
import ru.domen.api.ShortEntityResponse
import ru.domen.api.EntityNotFoundException

internal class GetShortEntity(
    private val entityDataProvider: EntityDataProvider
) {

    operator fun invoke(id: String): ShortEntityResponse {
        return entityDataProvider.findById(id)?.toOutputModel() ?: throw EntityNotFoundException(id)
    }

    private fun InternalEntityModel.toOutputModel(): ShortEntityResponse {
        return ShortEntityResponse(
            id = id,
            field = field
        )
    }

}