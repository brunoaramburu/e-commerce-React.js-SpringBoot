package com.gestionventa.demo.controllers.Usuario;

import com.gestionventa.demo.models.ResponseModel;
import com.gestionventa.demo.models.Usuario;
import com.gestionventa.demo.services.Usuario.UsuarioServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RegistrarUsuarioControllers {

    private final UsuarioServiceImp usuarioServiceImp;

    public RegistrarUsuarioControllers(UsuarioServiceImp usuarioServiceImp) {
        this.usuarioServiceImp = usuarioServiceImp;
    }

    @PostMapping("/v1")
    public ResponseEntity<String> registrar(@RequestBody Usuario usuario){


        ResponseModel<String> response = usuarioServiceImp.RegistrarUsuario(usuario);

        if(!response.getSucces()){
            return new ResponseEntity(response.getErrors(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(response.getObject(), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registro(@RequestBody Login registro){


        Usuario usuario = new Usuario();
        usuario.setEmail(registro.getEmail());
        usuario.setPassword(registro.getPassword());

        ResponseModel<String> response = usuarioServiceImp.registro(usuario);

        if(!response.getSucces()){
            return new ResponseEntity(response.getErrors(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(response.getObject(), HttpStatus.OK);
    }
}
