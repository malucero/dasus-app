package com.mauapps.dasusapp.repository

import com.mauapps.dasusapp.model.Producto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ProductoRepository: JpaRepository<Producto, Long> {

    fun findById(id:Long?): Producto?
    @Modifying
    @Query(nativeQuery=true)
    fun setOtherStock (@Param("stock")  stock:Long?, @Param("newStock")  newStock:Long?) : Integer?
}