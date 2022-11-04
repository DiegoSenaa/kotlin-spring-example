package br.com.diego.kotlinspring.controller

import br.com.diego.kotlinspring.model.Person
import br.com.diego.kotlinspring.services.PersonServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/person")
class PersonController {
    @Autowired
    private lateinit var service: PersonServices

    @GetMapping
    fun findAll() = service.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long) = service.findById(id)

    @PostMapping
    fun create(@RequestBody person: Person) = service.create(person)

    @PutMapping
    fun update(@RequestBody person: Person) = service.update(person)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.ok().build<Any>()
    }
}