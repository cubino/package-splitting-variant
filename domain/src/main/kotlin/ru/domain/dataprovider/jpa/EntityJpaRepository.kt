package ru.domain.dataprovider.jpa

import org.springframework.data.repository.CrudRepository

internal interface EntityJpaRepository : CrudRepository<Entity, String> {

}