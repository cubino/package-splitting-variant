package ru.domain.dataprovider

import ru.domain.InternalEntityModel
import ru.domain.dataprovider.jpa.Entity
import ru.domain.dataprovider.jpa.EntityJpaRepository
import org.springframework.data.repository.findByIdOrNull

internal class EntityDataProvider(
    private val repository: EntityJpaRepository
) {

    fun findById(id: String): InternalEntityModel? {
        return repository.findByIdOrNull(id)?.toModel()
    }

    fun deleteById(id: String) {
        repository.deleteById(id)
    }

    private fun Entity.toModel() =
        InternalEntityModel(
            id = id,
            field = field,
            version = version,
            createdByUserId = createdByUserId,
            modifiedByUserId = modifiedByUserId
        )


}