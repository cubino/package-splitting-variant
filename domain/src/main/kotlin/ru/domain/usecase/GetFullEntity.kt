package ru.domain.usecase

import ru.domain.InternalEntityModel
import ru.domain.dataprovider.EntityDataProvider
import ru.domain.dataprovider.UserServiceDataProvider
import ru.domen.api.EntityNotFoundException
import ru.domen.api.FullEntityResponse
import ru.domen.api.OwnerResponse

internal class GetFullEntity(
    private val entityDataProvider: EntityDataProvider,
    private val userServiceDataProvider: UserServiceDataProvider
) {

    operator fun invoke(id: String): FullEntityResponse {
        return entityDataProvider.findById(id)?.toOutputModel() ?: throw EntityNotFoundException(id)
    }

    private fun InternalEntityModel.toOutputModel(): FullEntityResponse {
        return FullEntityResponse(
            id = id,
            field = field,
            version = version,
            owner = userServiceDataProvider.findUserById(createdByUserId)?.let {
                OwnerResponse(
                    id = it.id,
                    name = it.name
                )
            }
        )
    }

}