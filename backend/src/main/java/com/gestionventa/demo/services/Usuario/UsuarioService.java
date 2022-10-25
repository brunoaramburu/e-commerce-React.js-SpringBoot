package com.gestionventa.demo.services.Usuario;

import com.gestionventa.demo.models.ResponseModel;
import com.gestionventa.demo.models.Usuario;

public interface UsuarioService {

    ResponseModel<String> RegistrarUsuario(Usuario usuario);
    String login(String email, String password);

}
