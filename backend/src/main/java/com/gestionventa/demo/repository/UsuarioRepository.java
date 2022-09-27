package com.gestionventa.demo.repository;

import com.gestionventa.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Boolean existsByDNI(String Dni);
    Boolean existsByNombreDeUsuario(String nombreDeUsuario);
    Boolean existsByEmail(String email);
}
