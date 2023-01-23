package ru.domain.dataprovider.jpa

import org.springframework.data.annotation.Id
import javax.persistence.Column

internal class Entity(

    @Id
    val id: String,

    @Column
    val version: Int,

    @Column
    val field: String,

    @Column
    val createdByUserId: String,

    @Column
    val modifiedByUserId: String

)