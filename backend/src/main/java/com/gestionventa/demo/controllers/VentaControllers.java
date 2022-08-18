package com.gestionventa.demo.controllers;
import com.gestionventa.demo.models.MapVentaYDetalle;
import com.gestionventa.demo.services.VentaServiceImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class VentaControllers {
    private final VentaServiceImp ventaServiceImp;

    public VentaControllers(VentaServiceImp ventaServiceImp) {
        this.ventaServiceImp = ventaServiceImp;
    }

    @GetMapping("/mapVentas")
    public Map<Integer, MapVentaYDetalle> MapVentaYDetalle(){

        return ventaServiceImp.MapVentaYDetalle();
    }

}
