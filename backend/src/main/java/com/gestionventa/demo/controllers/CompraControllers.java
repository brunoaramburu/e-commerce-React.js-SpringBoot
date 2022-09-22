package com.gestionventa.demo.controllers;
import com.gestionventa.demo.models.Compra;
import com.gestionventa.demo.services.CompraServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CompraControllers {
    private final CompraServiceImp ventaServiceImp;

    public CompraControllers(CompraServiceImp ventaServiceImp) {
        this.ventaServiceImp = ventaServiceImp;
    }

    @GetMapping("/compra")
    public List<Compra> ventas(){
        return ventaServiceImp.ventas();
    }
    @GetMapping("/compra/{id}")
    public Compra venta(@PathVariable(value = "id")Integer id){
        return ventaServiceImp.venta(id);
    }
    @PostMapping("/compra")
    public Compra saveVenta(Compra compra){
        return ventaServiceImp.saveVenta(compra);
    }
    @PutMapping("/compra")
    public void updateVenta(Compra compra){
        ventaServiceImp.updateVenta(compra);
    }

    @DeleteMapping("/compra")
    public void deleteVenta(Integer id){
        ventaServiceImp.deleteVenta(id);
    }

}
