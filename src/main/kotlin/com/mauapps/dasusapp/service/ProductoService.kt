package com.mauapps.dasusapp.service

import com.mauapps.dasusapp.model.Producto
import com.mauapps.dasusapp.repository.ProductoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

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
    fun updateDescription (producto: Producto):Producto {
        try {
            if (producto.name.equals("")){
                throw Exception("Nombre no puede estar vacio")
            }
            val response = productoRepository.findById(producto.id)
                ?: throw Exception("El id ${producto.id} en dieta no existe")
            response.apply {
                this.name = producto.name
            }
            return productoRepository.save(producto)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }



}