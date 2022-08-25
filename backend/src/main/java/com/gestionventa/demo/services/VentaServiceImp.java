package com.gestionventa.demo.services;

import com.gestionventa.demo.models.Venta;
import com.gestionventa.demo.repository.DetallesVentaRepository;
import com.gestionventa.demo.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaServiceImp implements VentaService{

    private final VentaRepository ventaRepository;
    private final DetallesVentaRepository detallesVentaRepository;


    public VentaServiceImp(VentaRepository ventaRepository, DetallesVentaRepository detallesVentaRepository) {
        this.ventaRepository = ventaRepository;
        this.detallesVentaRepository = detallesVentaRepository;
    }

    @Override
    public List<Venta> ventas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta venta(Integer id) {
        return ventaRepository.findById(id).get();
    }

    @Override
    public Venta saveVenta(Venta venta) {
        venta.setFechaVenta(LocalDateTime.now());
        return ventaRepository.save(venta);
    }
    @Override
    public void updateVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public void deleteVenta(Integer id) {
        ventaRepository.deleteById(id);
    }
}
