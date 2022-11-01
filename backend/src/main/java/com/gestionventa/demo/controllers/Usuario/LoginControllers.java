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
    public ResponseEntity<String> login(@RequestBody Login login) {



        String token = usuarioServiceImp.login(login.getEmail(),login.getPassword());

        if(token.equals("Usuario no encontrado")) return new ResponseEntity<>(token, HttpStatus.UNAUTHORIZED);

       if(token.equals("Contraseña incorrecta")) return new ResponseEntity<>(token, HttpStatus.UNAUTHORIZED);

       return ResponseEntity.ok("Authorization=" + token);
    }

}

class Login {
    private String email;
    private  String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public Login() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}