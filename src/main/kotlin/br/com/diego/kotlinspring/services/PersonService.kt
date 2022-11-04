package br.com.diego.kotlinspring.services

import br.com.diego.kotlinspring.exception.ResourceNotFoundException
import br.com.diego.kotlinspring.model.Person
import br.com.diego.kotlinspring.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PersonServices {
    @Autowired
    private lateinit var repository: PersonRepository

    fun create(person: Person)=  repository.save(person)


    fun findAll() = repository.findAll()

    fun findById(id: Long) = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }

    fun update(person: Person): Person {
        val entity: Person = repository.findById(person.id!!)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return repository.save(entity)
    }

    fun delete(id: Long) {
        val entity: Person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
        repository.delete(entity)
    }
}