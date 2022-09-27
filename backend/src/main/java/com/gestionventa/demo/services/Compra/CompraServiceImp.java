package com.gestionventa.demo.services.Compra;

import com.gestionventa.demo.models.Compra;
import com.gestionventa.demo.models.ResponseModel;
import com.gestionventa.demo.repository.DetallesCompraRepository;
import com.gestionventa.demo.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class CompraServiceImp implements CompraService {

    private final CompraRepository compraRepository;
    private final DetallesCompraRepository detallesCompraRepository;


    public CompraServiceImp(CompraRepository compraRepository, DetallesCompraRepository detallesCompraRepository) {
        this.compraRepository = compraRepository;
        this.detallesCompraRepository = detallesCompraRepository;
    }

    @Override
    public List<Compra> compras() {
        return compraRepository
                .findAll()
                .stream()
                .filter(c -> c.getEstado())
                .collect(toList());
    }

    @Override
    public ResponseModel<Compra> compra(Integer id) {
        ResponseModel<Compra> response = new ResponseModel<>();

        if(!compraRepository.existsById(id) || !compraRepository.findById(id).get().getEstado()){
            response.getErrors().add("no existe la compra");
            response.setSucces(false);
            return response;
        }
        response.setObject(compraRepository.findById(id).get());

        return response;
    }

    @Override
    public ResponseModel<?> saveCompra(Compra compra) {
        compra.setFechaVenta(LocalDateTime.now());
        return null;
    }
    @Override
    public ResponseModel<?> updateCompra(Compra compra) {
        compraRepository.save(compra);
        return null;
    }

    @Override
    public ResponseModel<?> deleteCompra(Integer id) {
        compraRepository.deleteById(id);
        return null;
    }
}
