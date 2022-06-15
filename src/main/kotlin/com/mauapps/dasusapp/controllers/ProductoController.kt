package com.mauapps.dasusapp.controllers

import com.mauapps.dasusapp.dto.stockDto
import com.mauapps.dasusapp.model.Producto
import com.mauapps.dasusapp.service.ProductoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/producto")

class ProductoController {
    @Autowired
    lateinit var productoService: ProductoService

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Producto?{
        return productoService.getById(id)
    }
    @GetMapping
    fun list ():List <Producto>{
        return productoService.list()
    }
    @PostMapping
    fun save (@RequestBody producto: Producto): Producto{
        return productoService.save(producto)
    }
    @PostMapping("/change/stock")
    fun updateOtherName (@RequestBody stockDto: stockDto): String?{
        return productoService.updateStock(stockDto)
    }
    @PutMapping
    fun update (@RequestBody producto: Producto): Producto{
        return productoService.update(producto)
    }
    @PatchMapping
    fun updateUno(@RequestBody producto: Producto): Producto {
        return productoService.updateUno(producto)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return productoService.delete(id)
    }

}
