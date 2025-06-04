package ru.domain.usecase

import ru.domain.dataprovider.AnotherServiceDataProvider
import ru.domain.dataprovider.EntityDataProvider
import ru.domen.api.SomeException

internal class DeleteEntity(
    private val anotherServiceDataProvider: AnotherServiceDataProvider,
    private val entityDataProvider: EntityDataProvider
) {

    operator fun invoke(id: String) {
        if (anotherServiceDataProvider.canUserDeleteEntity(id)) {
            entityDataProvider.deleteById(id)
        } else {
            throw SomeException("User can not delete entity")
        }
    }

}