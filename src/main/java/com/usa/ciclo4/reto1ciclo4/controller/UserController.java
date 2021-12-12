package com.usa.ciclo4.reto1ciclo4.controller;

import com.usa.ciclo4.reto1ciclo4.model.User;
import com.usa.ciclo4.reto1ciclo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    @Autowired
    /**
     *  Clase UserService
     */
    private UserService userService;

    /**
     * Devuleve todos los usuarios
     * @return
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     * Creacion de un nuevo usuario
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user){
        userService.save(user);
    }

    /**
     * Valida si el usuario existe
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }

    /**
     * Valida si el email existe
     * @param email
     * @return
     */
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
}
