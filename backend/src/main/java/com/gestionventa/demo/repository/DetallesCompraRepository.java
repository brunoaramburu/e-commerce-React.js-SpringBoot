package com.gestionventa.demo.repository;

import com.gestionventa.demo.models.DetallesCompra;
import com.gestionventa.demo.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetallesCompraRepository extends JpaRepository<DetallesCompra, Integer> {

    List<DetallesCompra> findByIdCompra(Compra idVentas);
    void deleteByIdCompra(Compra compra);
}
