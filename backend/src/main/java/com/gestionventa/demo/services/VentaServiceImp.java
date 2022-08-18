package com.gestionventa.demo.services;

import com.gestionventa.demo.models.MapVentaYDetalle;
import com.gestionventa.demo.models.Venta;
import com.gestionventa.demo.repository.DetallesVentaRepository;
import com.gestionventa.demo.repository.VentaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        venta.setEstado(true);
        return ventaRepository.save(venta);
    }

    @Override
    public void updateVenta(Venta venta) {
        venta.setMonto(venta.getMonto());
        ventaRepository.save(venta);
    }

    @Override
    public void deleteVenta(Integer id) {
        detallesVentaRepository.deleteByIdVentas(ventaRepository.findById(id).get());
        ventaRepository.deleteById(id);
    }

    @Override
    public Map<Integer, MapVentaYDetalle> MapVentaYDetalle() {

        Map<Integer, MapVentaYDetalle> map = new HashMap<>();
        List<Venta> ventas = ventaRepository.findAll();

        for(Venta venta: ventas){
            map.put(venta.getId(), new MapVentaYDetalle(venta, detallesVentaRepository.findByIdVentas(venta)));
        }

        return map;
    }
}
