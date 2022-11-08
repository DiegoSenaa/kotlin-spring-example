package br.com.diego.repository

import br.com.diego.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PersonRepository : JpaRepository<Person, Long>