package ru.domain.config

import org.springframework.context.annotation.Bean
import ru.domain.dataprovider.EntityDataProvider
import ru.domain.dataprovider.jpa.EntityJpaRepository
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import ru.another.domain.api.AnotherDomainApiClient
import ru.domain.dataprovider.AnotherServiceDataProvider
import ru.domain.dataprovider.UserServiceDataProvider
import ru.domain.entrypoint.EntityController
import ru.domain.usecase.DeleteEntity
import ru.domain.usecase.GetFullEntity
import ru.domain.usecase.GetShortEntity
import ru.user.domain.api.UserApiClient

@Configuration
@EnableJpaRepositories(basePackages = ["ru.domain.dataprovider"])
internal open class EntityDomainConfig(
    private val repository: EntityJpaRepository,
    private val anotherDomainApiClient: AnotherDomainApiClient,
    private val userApiClient: UserApiClient
) {

    @Bean
    open fun entityDataProvider(): EntityDataProvider {
        return EntityDataProvider(repository)
    }

    @Bean
    open fun anotherServiceDataProvider(): AnotherServiceDataProvider {
        return AnotherServiceDataProvider(anotherDomainApiClient)
    }

    @Bean
    open fun userServiceDataProvider(): UserServiceDataProvider {
        return UserServiceDataProvider(userApiClient)
    }

    @Bean
    open fun getFullEntity(): GetFullEntity {
        return GetFullEntity(
            entityDataProvider = entityDataProvider(),
            userServiceDataProvider = userServiceDataProvider()
        )
    }

    @Bean
    open fun getShortEntity(): GetShortEntity {
        return GetShortEntity(entityDataProvider())
    }

    @Bean
    open fun deleteEntity(): DeleteEntity {
        return DeleteEntity(
            entityDataProvider = entityDataProvider(),
            anotherServiceDataProvider = anotherServiceDataProvider()
        )
    }

    @Bean
    open fun entityController(): EntityController {
        return EntityController(
            getFullEntity = getFullEntity(),
            getShortEntity = getShortEntity(),
            deleteEntity = deleteEntity()
        )
    }

}