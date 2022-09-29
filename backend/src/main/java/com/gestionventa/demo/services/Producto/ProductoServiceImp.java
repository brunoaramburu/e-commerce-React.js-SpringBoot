package com.gestionventa.demo.services.Producto;

import com.gestionventa.demo.models.Producto;
import com.gestionventa.demo.models.ResponseModel;
import com.gestionventa.demo.repository.ProductoRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class ProductoServiceImp implements ProductoService {

    private final ProductoRepository productoRepository;

    private final ResponseModel<Producto> response;

    public ProductoServiceImp(ProductoRepository productoRepository, ResponseModel<Producto> response) {
        this.productoRepository = productoRepository;
        this.response = response;
    }

    @Async
    @Override
    public List<Producto> productos() {
        return productoRepository
                .findAll()
                .stream()
                .filter(p -> p.getEstado())
                .collect(toList());
    }

    @Override
    public ResponseModel<Producto> producto(Integer id) {
       // ResponseModel<Producto> response = new ResponseModel<>();
        if (!productoRepository.existsById(id) || !productoRepository.findById(id).get().getEstado()){
            response.getErrors().add("No existe el producto");
            response.setSucces(false);
            return response;
        }
        response.setObject(productoRepository.findById(id).get());
        return response;
    }

    @Override
    public ResponseModel<?> saveProducto(Producto producto) {

        //ResponseModel<Object> response = new ResponseModel<>();

        if(isBlank(producto.getNombres())){
            response.setSucces(false);
            response.getErrors().add("el producto requiere nombre");
        }
        if(isBlank(producto.getCategoria())){
            response.setSucces(false);
            response.getErrors().add("el producto requiere categoria");
        }
        if(isBlank(producto.getDescripcion())){
            response.setSucces(false);
            response.getErrors().add("el producto requiere una descripción");
        }
        if(producto.getPrecio() <= 0 || producto.getPrecio() == null){
            response.setSucces(false);
            response.getErrors().add("el producto requiere un precio");
        }
        if(producto.getStock() <= 0 || producto.getStock() == null){
            response.setSucces(false);
            response.getErrors().add("el producto requiere una cantidad de stock");
        }
        if(!response.getSucces()){
            return response;
        }

        producto.setEstado(true);
        producto.setFechaDeCreacion(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        response.setObject(productoRepository.save(producto));
        return response;
    }

    @Override
    public ResponseModel<?> updateProducto(Producto producto, Integer id) {

        //ResponseModel<Producto> response = new ResponseModel<>();
        if (!productoRepository.existsById(id)){
            response.getErrors().add("No existe el producto");
            response.setSucces(false);
            return response;
        }

        if(isBlank(producto.getNombres())){
            response.setSucces(false);
            response.getErrors().add("el producto requiere nombre para cambiarse");
        }
        if(isBlank(producto.getCategoria())){
            response.setSucces(false);
            response.getErrors().add("el producto requiere categoria para cambiarse");
        }
        if(isBlank(producto.getDescripcion())){
            response.setSucces(false);
            response.getErrors().add("el producto requiere una descripción para cambiarse");
        }
        if(producto.getPrecio() <= 0 || producto.getPrecio() == null){
            response.setSucces(false);
            response.getErrors().add("el producto requiere un precio para cambiarse");
        }
        if(producto.getStock() <= 0 || producto.getStock() == null){
            response.setSucces(false);
            response.getErrors().add("el producto requiere una cantidad de stock para cambiarse");
        }
        if(!response.getSucces()){
            return response;
        }

        producto.setId(id);
        producto.setEstado(true);
        response.setObject(productoRepository.save(producto));
        return response;
    }

    @Override
    public ResponseModel<?> deleteProducto(Integer id) {
       // ResponseModel<Producto> response = new ResponseModel<>();
        if (!productoRepository.existsById(id)){
            response.getErrors().add("No existe el producto");
            response.setSucces(false);
            return response;
        }
        Producto producto = productoRepository.findById(id).get();
        producto.setEstado(false);
        productoRepository.save(producto);
        return response;
    }
}
