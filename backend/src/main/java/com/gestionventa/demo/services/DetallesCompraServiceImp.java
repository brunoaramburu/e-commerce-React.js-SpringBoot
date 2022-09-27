package com.gestionventa.demo.services;

import com.gestionventa.demo.models.DetallesCompra;
import com.gestionventa.demo.models.Producto;
import com.gestionventa.demo.models.Compra;
import com.gestionventa.demo.models.ResponseModel;
import com.gestionventa.demo.repository.DetallesCompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class DetallesCompraServiceImp implements DetallesCompraService {

    private final DetallesCompraRepository detallesCompraRepository;

    private final ProductoServiceImp productoServiceImp;

    private final CompraServiceImp ventaServiceImp;

    public DetallesCompraServiceImp(DetallesCompraRepository detallesCompraRepository, ProductoServiceImp productoServiceImp, CompraServiceImp ventaServiceImp) {
        this.detallesCompraRepository = detallesCompraRepository;
        this.productoServiceImp = productoServiceImp;
        this.ventaServiceImp = ventaServiceImp;
    }


    @Override
    public List<DetallesCompra> detallesCompras() {
        return detallesCompraRepository.findAll();
    }

    @Override
    public List<DetallesCompra> findByIdCompra(Compra compra) {
        return detallesCompraRepository.findByIdCompra(compra);
    }

    @Override
    public DetallesCompra saveDetallesCompra(DetallesCompra detallesCompra) {
        return detallesCompraRepository.save(detallesCompra);
    }

    @Override
    public void deleteDetalleCompra(Integer id) {
        detallesCompraRepository.deleteById(id);
    }

    @Override
    public void updateProductosYCompra(List<DetallesCompra> detalleCompras) {

        AtomicReference<Double> total = new AtomicReference<>((double) 0);

        detalleCompras.stream().parallel().forEach(detallesCompra -> {
            ResponseModel<Producto> producto = productoServiceImp.producto(detallesCompra.getIdProducto().getId());
            producto.getObject().setStock(producto.getObject().getStock()- detallesCompra.getCantidad());
            productoServiceImp.updateProducto(producto.getObject(), producto.getObject().getId());
            total.updateAndGet(v -> v + detallesCompra.getPrecioVenta() * detallesCompra.getCantidad());
        });


        Compra compra = ventaServiceImp.venta(detalleCompras.get(0).getIdCompra().getId());
        compra.setMonto(total.get());
        ventaServiceImp.updateVenta(compra);
    }
}
