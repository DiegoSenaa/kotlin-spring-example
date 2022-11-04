package br.com.diego.kotlinspring.repository

import br.com.diego.kotlinspring.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PersonRepository : JpaRepository<Person, Long>