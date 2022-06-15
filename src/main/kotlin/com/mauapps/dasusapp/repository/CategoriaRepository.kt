package com.mauapps.dasusapp.repository

import com.mauapps.dasusapp.model.Categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CategoriaRepository: JpaRepository<Categoria, Long> {

    fun findById(id:Long?): Categoria?


}