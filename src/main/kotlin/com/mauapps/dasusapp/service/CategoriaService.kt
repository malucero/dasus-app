package com.mauapps.dasusapp.service

import com.mauapps.dasusapp.model.Categoria
import com.mauapps.dasusapp.repository.CategoriaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class CategoriaService {
    @Autowired
    lateinit var categoriaRepository: CategoriaRepository;

    fun list ():List<Categoria>{
        return categoriaRepository.findAll()
    }
    fun getById (id: Long?): Categoria?{
        return categoriaRepository.findById(id)
    }
    fun save(categoria: Categoria): Categoria {
        return categoriaRepository.save(categoria)
    }

    fun update (categoria: Categoria): Categoria {
        try {
            if (categoria.descripcion.equals("")){
                throw Exception("Descrpcion no puede estar vacio")
            }
            val response = categoriaRepository.findById(categoria.id)
                ?: throw Exception("El id ${categoria.id} en producto no existe")
            response.apply {
                this.descripcion = categoria.descripcion
            }
            return categoriaRepository.save(categoria)
        }

        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Categoria no encontrada")
        }
    }

    fun updateUno (categoria: Categoria): Categoria {
        val response=categoriaRepository.findById(categoria.id)
            ?: throw Exception()
        response.apply {
            descripcion=categoria.descripcion
        }
        return categoriaRepository.save(response)
    }

    fun delete (id:Long): Boolean {
        categoriaRepository.deleteById(id)
        return true
    }

}