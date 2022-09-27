package com.gestionventa.demo.services.Usuario;

import com.gestionventa.demo.models.ResponseModel;
import com.gestionventa.demo.models.Usuario;
import com.gestionventa.demo.repository.UsuarioRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public ResponseModel<String> RegistrarUsuario(Usuario usuario) {
        ResponseModel<String> response = new ResponseModel<>();

        //validar datos
        if(isBlank(usuario.getNombreDeUsuario())){
            response.getErrors().add("se necesita nombre de usuario");
            response.setSucces(false);
        }
        if(isBlank(usuario.getPassword())){
            response.getErrors().add("se necesita una contraseña");
            response.setSucces(false);
        }
        if(isBlank(usuario.getNombres())){
            response.getErrors().add("se necesita nombre");
            response.setSucces(false);
        }
        if(isBlank(usuario.getApellido())){
            response.getErrors().add("se necesita apellido");
            response.setSucces(false);
        }
        if(isBlank(usuario.getEmail())){
            response.getErrors().add("se necesita email");
            response.setSucces(false);
        }
        if(isBlank(usuario.getDNI())){
            response.getErrors().add("se necesita DNI");
            response.setSucces(false);
        }
        if(!response.getSucces()){
            return response;
        }
        // ver que no existan
        if(usuarioRepository.existsByEmail(usuario.getEmail())){
            response.getErrors().add("ya existe el email: "+ usuario.getEmail() + " registrado");
            response.setSucces(false);
            return response;
        }
        if(usuarioRepository.existsByDNI(usuario.getDNI())){
            response.getErrors().add("ya existe el DNI: "+ usuario.getDNI() + " registrado");
            response.setSucces(false);
            return response;
        }
        if(usuarioRepository.existsByNombreDeUsuario(usuario.getNombreDeUsuario())){
            response.getErrors().add("ya existe el Nombre de usuario: "+ usuario.getNombreDeUsuario() + " registrado");
            response.setSucces(false);
            return response;
        }

        Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon.hash(2, 1024, 2, usuario.getPassword());
        usuario.setPassword(hash);

        usuario.setEstado(true);
        usuario.setFechaDeCreacion(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        usuarioRepository.save(usuario);
        response.setObject("el usuario: " + usuario.getNombreDeUsuario() + " se registro correctamente");
        return response;
    }

    @Override
    public ResponseModel<String> login() {
        return null;
    }
}
