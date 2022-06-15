package com.mauapps.dasusapp.repository

import com.mauapps.dasusapp.model.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository

interface UsersRepository: JpaRepository<Users, Long> {

    fun findById(id:Long?): Users?
    @Query(nativeQuery=true)
    fun getLogin (@Param("username")  username:String?, @Param("password")  password:String?) : Users?

}