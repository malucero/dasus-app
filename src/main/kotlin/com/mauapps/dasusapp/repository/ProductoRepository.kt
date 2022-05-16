package com.mauapps.dasusapp.repository

import com.mauapps.dasusapp.model.Producto
import org.springframework.data.jpa.repository.JpaRepository

interface ProductoRepository:JpaRepository<Producto, Long> {

    fun findById(id:Long?): Producto?
}