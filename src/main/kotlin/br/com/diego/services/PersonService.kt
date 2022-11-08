package br.com.diego.services

import br.com.diego.exception.RequiredObjectIsNullException
import br.com.diego.exception.ResourceNotFoundException
import br.com.diego.model.Person
import br.com.diego.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Objects


@Service
class PersonServices {
    @Autowired
    private lateinit var repository: PersonRepository

    fun create(person: Person?) : Person {
        if(person == null) throw  RequiredObjectIsNullException()
        return repository.save(person)
    }


    fun findAll() = repository.findAll()

    fun findById(id: Long) = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }

    fun update(person: Person?): Person {
        if(person == null) throw  RequiredObjectIsNullException()
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