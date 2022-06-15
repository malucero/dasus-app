package com.mauapps.dasusapp.model

import javax.persistence.*

@Entity
@Table(name = "proveedor")
class Proveedor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var name: String? = null
    var ciudad: String? = null
}