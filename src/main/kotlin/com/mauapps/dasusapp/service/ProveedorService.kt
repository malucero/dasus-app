package com.mauapps.dasusapp.service

import com.mauapps.dasusapp.model.Producto
import com.mauapps.dasusapp.model.Proveedor
import com.mauapps.dasusapp.repository.ProductoRepository
import com.mauapps.dasusapp.repository.ProveedorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class ProveedorService {
    @Autowired
    lateinit var proveedorRepository: ProveedorRepository;

    fun list ():List<Proveedor>{
        return proveedorRepository.findAll()
    }
    fun getById (id: Long?): Proveedor?{
        return proveedorRepository.findById(id)
    }
    fun save(proveedor: Proveedor): Proveedor {
        return proveedorRepository.save(proveedor)
    }

    fun update (proveedor: Proveedor): Proveedor {
        try {
            if (proveedor.name.equals("")){
                throw Exception("Nombre no puede estar vacio")
            }
            val response = proveedorRepository.findById(proveedor.id)
                ?: throw Exception("El id ${proveedor.id} en proveedor no existe")
            response.apply {
                this.name = proveedor.name
            }
            return proveedorRepository.save(proveedor)
        }

        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Proveedor no encontrado")
        }
    }

    fun updateUno (proveedor: Proveedor): Proveedor {
        val response=proveedorRepository.findById(proveedor.id)
            ?: throw Exception()
        response.apply {
            name=proveedor.name
        }
        return proveedorRepository.save(response)
    }

    fun delete (id:Long): Boolean {
        proveedorRepository.deleteById(id)
        return true
}
}