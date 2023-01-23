package ru.domain.config

import org.springframework.context.annotation.Bean
import ru.domain.dataprovider.EntityDataProvider
import ru.domain.dataprovider.jpa.EntityJpaRepository
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import ru.domain.entrypoint.EntityController
import ru.domain.entrypoint.EntityEmbeddedServer
import ru.domain.usecase.GetFullEntity
import ru.domain.usecase.GetShortEntity

@Configuration
@EnableJpaRepositories(basePackages = ["ru.domain.dataprovider"])
internal open class EntityConfig(
    private val repository: EntityJpaRepository
) {

    @Bean
    open fun entityDataProvider(): EntityDataProvider {
        return EntityDataProvider(repository)
    }

    @Bean
    open fun getFullEntity(): GetFullEntity {
        return GetFullEntity(entityDataProvider())
    }

    @Bean
    open fun getShortEntity(): GetShortEntity {
        return GetShortEntity(entityDataProvider())
    }

    @Bean
    open fun entityEmbeddedServer(): EntityEmbeddedServer {
        return EntityEmbeddedServer(
            getFullEntity(), getShortEntity()
        )
    }

    @Bean
    open fun entityController(): EntityController {
        return EntityController(
            getFullEntity(), getShortEntity()
        )
    }

}