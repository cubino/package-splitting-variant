package ru.domain.entrypoint

import org.springframework.web.bind.annotation.DeleteMapping
import ru.domain.usecase.GetFullEntity
import ru.domain.usecase.GetShortEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import ru.domain.usecase.DeleteEntity
import ru.domen.api.ApiClient
import ru.domen.api.FullEntityResponse
import ru.domen.api.ShortEntityResponse

@RequestMapping("/entity", produces = ["application/json"])
internal class EntityController(
    private val getFullEntity: GetFullEntity,
    private val getShortEntity: GetShortEntity,
    private val deleteEntity: DeleteEntity
) : ApiClient {

    @GetMapping("/use_case_1/{id}")
    override fun getFullEntity(@PathVariable id: String): FullEntityResponse {
        return getFullEntity.invoke(id)
    }

    @GetMapping("/use_case_2/{id}")
    override fun getShortEntity(@PathVariable id: String): ShortEntityResponse {
        return getShortEntity.invoke(id)
    }

    @DeleteMapping("/{id}")
    override fun deleteEntity(id: String) {
        deleteEntity.invoke(id)
    }

}