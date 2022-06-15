package com.mauapps.dasusapp.controllers

import com.mauapps.dasusapp.model.Categoria
import com.mauapps.dasusapp.service.CategoriaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categoria")

class CategoriaController {
    @Autowired
    lateinit var categoriaService: CategoriaService

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Categoria?{
        return categoriaService.getById(id)
    }
    @GetMapping
    fun list ():List <Categoria>{
        return categoriaService.list()
    }
    @PostMapping
    fun save (@RequestBody categoria: Categoria): Categoria {
        return categoriaService.save(categoria)
    }
    @PutMapping
    fun update (@RequestBody categoria: Categoria): Categoria {
        return categoriaService.update(categoria)
    }
    @PatchMapping
    fun updateUno(@RequestBody categoria: Categoria): Categoria {
        return categoriaService.updateUno(categoria)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return categoriaService.delete(id)
    }
}