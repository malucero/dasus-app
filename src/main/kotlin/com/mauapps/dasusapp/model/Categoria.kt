package com.mauapps.dasusapp.model

import javax.persistence.*

@Entity
@Table(name = "categoria")

class Categoria {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var descripcion: String? = null
}