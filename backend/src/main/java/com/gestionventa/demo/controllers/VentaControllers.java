package com.gestionventa.demo.controllers;
import com.gestionventa.demo.services.VentaServiceImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class VentaControllers {
    private final VentaServiceImp ventaServiceImp;

    public VentaControllers(VentaServiceImp ventaServiceImp) {
        this.ventaServiceImp = ventaServiceImp;
    }



}
