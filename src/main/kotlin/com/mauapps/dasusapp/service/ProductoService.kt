package com.mauapps.dasusapp.service

import com.mauapps.dasusapp.model.Producto
import com.mauapps.dasusapp.repository.ProductoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductoService {
    @Autowired
    lateinit var productoRepository: ProductoRepository;

    fun list ():List<Producto>{
        return productoRepository.findAll()
    }
    fun getById (id: Long?):Producto?{
        return productoRepository.findById(id)
    }
    fun save (producto:Producto):Producto{
        return productoRepository.save(producto)
    }

    fun update (producto: Producto):Producto{
        productoRepository.findById(producto.id) ?: throw Exception()

        return productoRepository.save(producto)
    }

    fun updateName(producto: Producto):Producto{
        val response=productoRepository.findById(producto.id)
            ?: throw Exception()
        response.apply {
            name=producto.name
        }

        return productoRepository.save(response)
    }


    fun delete (id:Long): Boolean {
        productoRepository.deleteById(id)
        return true
    }



}