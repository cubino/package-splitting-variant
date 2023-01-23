package ru.domain.usecase

import ru.domain.InternalModel
import ru.domain.dataprovider.EntityDataProvider
import ru.domen.api.FullEntity
import javax.persistence.EntityNotFoundException

internal class GetFullEntity(
    private val entityDataProvider: EntityDataProvider
) {

    operator fun invoke(id: String): FullEntity {
        return entityDataProvider.getEntity(id)?.toOutputModel() ?: throw EntityNotFoundException(id)
    }

    private fun InternalModel.toOutputModel(): FullEntity {
        return FullEntity(
            id = id,
            field = field,
            version = version
        )
    }

}