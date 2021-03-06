package com.mauapps.dasusapp.model

import javax.persistence.*

@Entity
@Table(name = "producto")
class Producto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var name: String? = null
    var stock: Long? = null
    @Column(name = "proveedor_id")
    var proveedorId: Long? = null
    @Column(name = "categoria_id")
    var categoriaId: Long? = null
}