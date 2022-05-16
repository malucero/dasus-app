package com.mauapps.dasusapp.controllers

import com.mauapps.dasusapp.model.Producto
import com.mauapps.dasusapp.repository.ProductoRepository
import com.mauapps.dasusapp.service.ProductoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/producto")

class ProductoController {
    @Autowired
    lateinit var productoService: ProductoService

    @GetMapping
    fun list ():List <Producto>{
        return productoService.list()

    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Producto?{
        return productoService.getById(id)
    }
    @PostMapping
    fun save (@RequestBody producto: Producto): Producto{
        return productoService.save(producto)
    }

    @PutMapping
    fun update (@RequestBody producto: Producto): Producto{
        return productoService.update(producto)
    }

    @PatchMapping
    fun updateName(@RequestBody producto: Producto): Producto {
        return productoService.updateName(producto)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return productoService.delete(id)
    }

    }
