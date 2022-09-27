package com.gestionventa.demo.controllers;
import com.gestionventa.demo.models.Compra;
import com.gestionventa.demo.models.ResponseModel;
import com.gestionventa.demo.services.Compra.CompraServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CompraControllers {
    private final CompraServiceImp compraServiceImp;

    public CompraControllers(CompraServiceImp compraServiceImp) {
        this.compraServiceImp = compraServiceImp;
    }

    @GetMapping("/compra")
    public ResponseEntity<Compra> compras(){
        ResponseModel<Compra> errores = new ResponseModel<Compra>(new Compra());

        errores.setObject(new Compra());
        errores.getErrors().add("hola");
        errores.getErrors().add("como va");

        List<Compra> compraList = new ArrayList<>();

        compraList.add(new Compra());

        if(compraList.get(0).getId() != null){
            return new ResponseEntity(compraList, HttpStatus.OK);
        }
        return new ResponseEntity(errores.getErrors(), HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/compra/{id}")
    public ResponseEntity<Compra> compra(@PathVariable(value = "id")Integer id){

        ResponseModel<Compra> errores = new ResponseModel<Compra>(new Compra());

        errores.getErrors().add("hola");
        errores.getErrors().add("como va");

        if(id == 0){
            return new ResponseEntity(errores.getErrors(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(errores.getObject(), HttpStatus.OK);
    }
    @PostMapping("/compra")
    public ResponseEntity<?> saveCompra(@RequestBody Compra compra){
        compraServiceImp.saveCompra(compra);

        return ResponseEntity.badRequest().body("error");
    }
    @PutMapping("/compra/{id}")
    public void updateCompra(@RequestBody Compra compra, @PathVariable(value = "id") Integer id){

        compraServiceImp.updateCompra(compra);
    }

    @DeleteMapping("/compra/{id}")
    public void deleteCompra(@PathVariable(value = "id") Integer id){
        compraServiceImp.deleteCompra(id);
    }

}
