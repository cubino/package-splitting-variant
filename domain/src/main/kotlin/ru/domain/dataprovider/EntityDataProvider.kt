package ru.domain.dataprovider

import ru.domain.InternalModel
import ru.domain.dataprovider.jpa.Entity
import ru.domain.dataprovider.jpa.EntityJpaRepository
import org.springframework.data.repository.findByIdOrNull

internal class EntityDataProvider(
    private val repository: EntityJpaRepository
) {

    fun getEntity(id: String): InternalModel? {
        return repository.findByIdOrNull(id)?.toModel()
    }

    private fun Entity.toModel() =
        InternalModel(
            id = id,
            field = field,
            version = version,
            createdByUserId = createdByUserId,
            modifiedByUserId = modifiedByUserId
        )


}