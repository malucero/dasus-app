package com.mauapps.dasusapp.service

import com.mauapps.dasusapp.dto.stockDto
import com.mauapps.dasusapp.model.Producto
import com.mauapps.dasusapp.repository.ProductoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import javax.transaction.Transactional

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
    fun save(producto: Producto):Producto{
            return productoRepository.save(producto)
    }

    fun update (producto: Producto):Producto{
        try {
            if (producto.name.equals("")){
                throw Exception("Nombre no puede estar vacio")
            }
            val response = productoRepository.findById(producto.id)
                ?: throw Exception("El id ${producto.id} en producto no existe")
            response.apply {
                this.name = producto.name
            }
            return productoRepository.save(producto)
        }

        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Producto no encontrada")
        }
    }

    @Transactional
    fun updateStock (stockDto: stockDto): String?{
        val rowsUpdate=productoRepository.setOtherStock(stockDto.stock, stockDto.newStock)
        return "${rowsUpdate} rows updated"
    }

    fun updateUno (producto: Producto): Producto{
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