package ru.domain.usecase

import ru.domain.InternalModel
import ru.domain.dataprovider.EntityDataProvider
import ru.domen.api.ShortEntity
import javax.persistence.EntityNotFoundException

internal class GetShortEntity(
    private val entityDataProvider: EntityDataProvider
) {

    operator fun invoke(id: String): ShortEntity {
        return entityDataProvider.getEntity(id)?.toOutputModel() ?: throw EntityNotFoundException(id)
    }

    private fun InternalModel.toOutputModel(): ShortEntity {
        return ShortEntity(
            id = id,
            field = field,
        )
    }

}