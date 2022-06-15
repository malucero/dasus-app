package com.mauapps.dasusapp.controllers

import com.mauapps.dasusapp.model.Proveedor
import com.mauapps.dasusapp.service.ProveedorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/proveedor")
class ProveedorController {
    @Autowired
    lateinit var proveedorService: ProveedorService

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Proveedor?{
        return proveedorService.getById(id)
    }
    @GetMapping
    fun list ():List <Proveedor>{
        return proveedorService.list()
    }
    @PostMapping
    fun save (@RequestBody proveedor: Proveedor): Proveedor{
        return proveedorService.save(proveedor)
    }
    @PutMapping
    fun update (@RequestBody proveedor: Proveedor): Proveedor{
        return proveedorService.update(proveedor)
    }
    @PatchMapping
    fun updateUno(@RequestBody proveedor: Proveedor): Proveedor {
        return proveedorService.updateUno(proveedor)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return proveedorService.delete(id)
    }


}