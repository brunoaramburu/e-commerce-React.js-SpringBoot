package com.gestionventa.demo.services;

import com.gestionventa.demo.models.DetallesVenta;
import com.gestionventa.demo.models.Venta;
import com.gestionventa.demo.repository.DetallesVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallesVentaServiceImp implements DetallesVentaService{

    private final DetallesVentaRepository detallesVentaRepository;

    public DetallesVentaServiceImp(DetallesVentaRepository detallesVentaRepository) {
        this.detallesVentaRepository = detallesVentaRepository;
    }


    @Override
    public List<DetallesVenta> detallesVentas() {
        return detallesVentaRepository.findAll();
    }

    @Override
    public List<DetallesVenta> findByIdVentas(Venta venta) {
        return detallesVentaRepository.findByIdVentas(venta);
    }

    @Override
    public void saveDetallesVenta(DetallesVenta detallesVenta) {
        detallesVentaRepository.save(detallesVenta);
    }

    @Override
    public void deleteDetalleVenta(Integer id) {
        detallesVentaRepository.deleteById(id);
    }
}
