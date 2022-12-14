package com.app.subidaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.subidaservice.entity.IngresoSalida;
import com.app.subidaservice.service.IngresoSalidaService;

@RestController
@RequestMapping("/ingresosSalidas")
public class IngresoSalidaController {
    
    @Autowired
    IngresoSalidaService ingresoSalidaService;

    @GetMapping
    public ResponseEntity<List<IngresoSalida>> getAll() {
        List <IngresoSalida> ingresosSalidas = ingresoSalidaService.obtenerIngresosSalidas();
        if(ingresosSalidas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ingresosSalidas);
    }

    @GetMapping("/atrasos/{rut}")
    public ResponseEntity<List<Integer>> getAtrasos(@PathVariable("rut") String rut) {
        List <Integer> atrasos = ingresoSalidaService.obtenerCantidadAtrasos(rut);
        if(atrasos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(atrasos);
    }

    @GetMapping("/atrasos/rut")
    public ResponseEntity<List<String>> getAtrasosRut() {
        List <String> atrasosRut = ingresoSalidaService.obtenerRut();
        if(atrasosRut.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(atrasosRut);
    }

    @GetMapping("/fecha")
    public ResponseEntity<String> getFecha() {
        String fecha = ingresoSalidaService.obtenerFecha();
        if(fecha.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(fecha);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngresoSalida> getById(@PathVariable("id") Long id) {
        IngresoSalida ingresoSalida = ingresoSalidaService.obtenerIngresoSalida(id);
        if(ingresoSalida == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingresoSalida);
    }

    @GetMapping("/inasistencias")
    public ResponseEntity<List<IngresoSalida>> getInasistencias() {
        List <IngresoSalida> inasistencias = ingresoSalidaService.obtenerInasistencias();
        if(inasistencias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(inasistencias);
    }

    @GetMapping("/salidas")
    public ResponseEntity<List<IngresoSalida>> getSalidas() {
        List <IngresoSalida> salidas = ingresoSalidaService.obtenerSalidas();
        if(salidas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(salidas);
    }
}
