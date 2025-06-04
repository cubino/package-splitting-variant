package ru.domain.dataprovider

import ru.another.domain.api.AnotherDomainApiClient

class AnotherServiceDataProvider(
    private val anotherDomainApiClient: AnotherDomainApiClient
) {

    fun canUserDeleteEntity(id : String): Boolean {
       return anotherDomainApiClient.foo(id)
    }

}