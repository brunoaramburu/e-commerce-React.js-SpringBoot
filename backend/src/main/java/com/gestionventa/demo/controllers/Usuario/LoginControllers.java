package com.gestionventa.demo.controllers.Usuario;

import com.gestionventa.demo.services.Usuario.UsuarioServiceImp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class LoginControllers {

    private final UsuarioServiceImp usuarioServiceImp;


    public LoginControllers(UsuarioServiceImp usuarioServiceImp) {
        this.usuarioServiceImp = usuarioServiceImp;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(String email, String password) {

        String token = usuarioServiceImp.login(email,password);

        if(token.equals("Usuario no encontrado")) return new ResponseEntity<>(token, HttpStatus.UNAUTHORIZED);

       if(token.equals("Contraseña incorrecta")) return new ResponseEntity<>(token, HttpStatus.UNAUTHORIZED);

       return ResponseEntity.ok("Authorization=" + token);
    }

}
