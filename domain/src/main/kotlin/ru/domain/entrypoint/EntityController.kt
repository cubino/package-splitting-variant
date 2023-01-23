package ru.domain.entrypoint

import ru.domain.usecase.GetFullEntity
import ru.domain.usecase.GetShortEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import ru.domen.api.FullEntity
import ru.domen.api.ShortEntity

@RequestMapping("/entity", produces = ["application/json"])
internal class EntityController(
    private val getFullEntity: GetFullEntity,
    private val getShortEntity: GetShortEntity,
) {

    @GetMapping("/full/{id}")
    fun getFullEntityById(@PathVariable id: String): FullEntity {
        return getFullEntity.invoke(id)
    }

    @GetMapping("/short/{id}")
    fun getShortEntityById(@PathVariable id: String): ShortEntity {
        return getShortEntity.invoke(id)
    }

}