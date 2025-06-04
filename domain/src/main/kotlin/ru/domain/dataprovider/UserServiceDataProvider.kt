package ru.domain.dataprovider

import ru.domain.InternalUserModel
import ru.user.domain.api.User
import ru.user.domain.api.UserApiClient

internal class UserServiceDataProvider(
    private val userApiClient: UserApiClient
) {

    fun findUserById(id: String): InternalUserModel? {
        return userApiClient.findUserById(id)?.toModel()
    }

    private fun User.toModel() = InternalUserModel(
        id = id,
        email = email,
        name = name
    )

}