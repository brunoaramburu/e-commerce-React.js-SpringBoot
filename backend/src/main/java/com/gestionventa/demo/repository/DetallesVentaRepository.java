package com.gestionventa.demo.repository;

import com.gestionventa.demo.models.DetallesVenta;
import com.gestionventa.demo.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetallesVentaRepository extends JpaRepository<DetallesVenta, Integer> {

    List<DetallesVenta> findByIdVentas(Venta idVentas);

    void deleteByIdVentas(Venta venta);
}
