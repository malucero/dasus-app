package com.mauapps.dasusapp.controllers


import com.mauapps.dasusapp.model.Users
import com.mauapps.dasusapp.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")

class UserController {
    @Autowired
    lateinit var userService: UserService

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Users?{
        return userService.getById(id)
    }
    @GetMapping
    fun list ():List <Users>{
        return userService.list()
    }
    @PostMapping
    fun save (@RequestBody users: Users): Users {
        return userService.save(users)
    }
    @PostMapping ("/auth/login")
    fun login (@RequestBody users: Users): Users? {
        return userService.validarUsuario(users)
    }
}