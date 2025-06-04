package ru.domen.api

class SomeException(override val message: String) : RuntimeException(message)

class EntityNotFoundException(id: String) : RuntimeException()