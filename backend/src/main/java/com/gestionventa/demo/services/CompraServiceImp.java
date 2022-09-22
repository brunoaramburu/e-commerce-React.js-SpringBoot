package com.gestionventa.demo.services;

import com.gestionventa.demo.models.Compra;
import com.gestionventa.demo.repository.DetallesCompraRepository;
import com.gestionventa.demo.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompraServiceImp implements CompraService {

    private final CompraRepository compraRepository;
    private final DetallesCompraRepository detallesCompraRepository;


    public CompraServiceImp(CompraRepository compraRepository, DetallesCompraRepository detallesCompraRepository) {
        this.compraRepository = compraRepository;
        this.detallesCompraRepository = detallesCompraRepository;
    }

    @Override
    public List<Compra> ventas() {
        return compraRepository.findAll();
    }

    @Override
    public Compra venta(Integer id) {
        return compraRepository.findById(id).get();
    }

    @Override
    public Compra saveVenta(Compra compra) {
        compra.setFechaVenta(LocalDateTime.now());
        return compraRepository.save(compra);
    }
    @Override
    public void updateVenta(Compra compra) {
        compraRepository.save(compra);
    }

    @Override
    public void deleteVenta(Integer id) {
        compraRepository.deleteById(id);
    }
}
