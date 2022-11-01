package com.gestionventa.demo.controllers;

import com.gestionventa.demo.models.Producto;
import com.gestionventa.demo.models.ResponseModel;
import com.gestionventa.demo.models.Usuario;
import com.gestionventa.demo.repository.UsuarioRepository;
import com.gestionventa.demo.services.Producto.ProductoServiceImp;
import com.gestionventa.demo.util.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductoControllers {

    private final ProductoServiceImp productoServiceImp;

    private final UsuarioRepository usuarioRepository;
    private final JWTUtil jwtUtil;


    public ProductoControllers(ProductoServiceImp productoServiceImp, UsuarioRepository usuarioRepository, JWTUtil jwtUtil) {
        this.productoServiceImp = productoServiceImp;
        this.usuarioRepository = usuarioRepository;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/productos")
    @Async
    public List<Producto> productos(){
        return productoServiceImp.productos();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> producto(@PathVariable("id") Integer id){

        ResponseModel<Producto> response = productoServiceImp.producto(id);

        if (!response.getSucces()){
            return new ResponseEntity(response.getErrors(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Producto>(response.getObject(),HttpStatus.OK);
    }

    @PostMapping("/productos")
    public ResponseEntity<?> saveProducto(@RequestHeader(value = "Authorization",required = false) String token, @RequestBody Producto producto){

        String usuarioId = jwtUtil.getKey(token);

        if (isBlank(usuarioId)){
            return new ResponseEntity<>("no authorized", HttpStatus.UNAUTHORIZED);
        }

        Usuario vendedor = usuarioRepository.findById(Integer.valueOf(usuarioId)).get();

        if (vendedor == null){
            return new ResponseEntity<>("no authorized", HttpStatus.UNAUTHORIZED);
        }

         producto.setVendedor(vendedor);
         ResponseModel<?> response = productoServiceImp.saveProducto(producto);

         if(!response.getSucces()){
             return new ResponseEntity(response.getErrors(), HttpStatus.BAD_REQUEST);
         }

         return new ResponseEntity<>("se creo el producto correctamente", HttpStatus.OK);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable(value = "id") Integer id ,@RequestBody Producto producto){
        ResponseModel<?> response = productoServiceImp.updateProducto(producto,id);

        if (!response.getSucces()){
            return new ResponseEntity<>(response.getErrors(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Se actualizo correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable("id") Integer id){

        ResponseModel response = productoServiceImp.deleteProducto(id);

        if(!response.getSucces()){
            return new ResponseEntity<>(response.getErrors(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("se elimino correctamente", HttpStatus.OK);
    }
}
