package com.gestionventa.demo.services;

import com.gestionventa.demo.models.DetallesVenta;
import com.gestionventa.demo.models.Producto;
import com.gestionventa.demo.models.Venta;
import com.gestionventa.demo.repository.DetallesVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class DetallesVentaServiceImp implements DetallesVentaService{

    private final DetallesVentaRepository detallesVentaRepository;

    private final ProductoServiceImp productoServiceImp;

    private final VentaServiceImp ventaServiceImp;

    public DetallesVentaServiceImp(DetallesVentaRepository detallesVentaRepository, ProductoServiceImp productoServiceImp, VentaServiceImp ventaServiceImp) {
        this.detallesVentaRepository = detallesVentaRepository;
        this.productoServiceImp = productoServiceImp;
        this.ventaServiceImp = ventaServiceImp;
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
    public DetallesVenta saveDetallesVenta(DetallesVenta detallesVenta) {
        return detallesVentaRepository.save(detallesVenta);
    }

    @Override
    public void deleteDetalleVenta(Integer id) {
        detallesVentaRepository.deleteById(id);
    }

    @Override
    public void updateProductosYventa(List<DetallesVenta> detallesVentas) {

        AtomicReference<Double> total = new AtomicReference<>((double) 0);

        detallesVentas.stream().parallel().forEach(detallesVenta -> {
            Producto producto = productoServiceImp.poducto(detallesVenta.getIdProducto().getId());
            producto.setStock(producto.getStock()-detallesVenta.getCantidad());
            productoServiceImp.updateProducto(producto);
            total.updateAndGet(v -> new Double((double) (v + detallesVenta.getPrecioVenta() * detallesVenta.getCantidad())));
        });


        Venta venta = ventaServiceImp.venta(detallesVentas.get(0).getIdVentas().getId());
        venta.setMonto(total);
        ventaServiceImp.updateVenta(venta);
    }
}
