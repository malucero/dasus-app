package com.mauapps.dasusapp.service

import com.mauapps.dasusapp.model.Users
import com.mauapps.dasusapp.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class UserService {
    @Autowired
    lateinit var usersRepository: UsersRepository

    fun list ():List<Users>{
        return usersRepository.findAll()
    }
    fun getById (id: Long?): Users?{
        return usersRepository.findById(id)
    }
    fun save(users: Users): Users {
        return usersRepository.save(users)
    }
    fun validarUsuario (users: Users):Users? {
        return usersRepository.getLogin(users.username,users.password)
    }



}