package com.gestionventa.demo.services.Compra;

import com.gestionventa.demo.models.Compra;
import com.gestionventa.demo.models.ResponseModel;
import com.gestionventa.demo.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CompraServiceImp implements CompraService {

    private final CompraRepository compraRepository;
    private final ResponseModel<Compra> response;


    public CompraServiceImp(CompraRepository compraRepository, ResponseModel<Compra> response) {
        this.compraRepository = compraRepository;
        this.response = response;
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
        //ResponseModel<Compra> response = new ResponseModel<>();

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
       // ResponseModel<?> response = new ResponseModel<>();

        compra.setFechaVenta(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        compra.setEstado(true);
        compra.setFechaVenta(LocalDateTime.now());

        response.setObject(compraRepository.save(compra));

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
