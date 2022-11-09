package com.app.subidaservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.subidaservice.entity.IngresoSalida;
import com.app.subidaservice.repository.IngresoSalidaRepository;

@Service
public class IngresoSalidaService {
    @Autowired
    IngresoSalidaRepository ingresoSalidaRepository;

    public List<IngresoSalida> obtenerIngresosSalidas() {
        return ingresoSalidaRepository.findAll();
    }

    public IngresoSalida obtenerIngresoSalida(Long id) {
        return ingresoSalidaRepository.findById(id).orElse(null);
    }

    // Va a cambiar, debido a que se le pasa un archivo
    public IngresoSalida crearIngresoSalida(IngresoSalida ingresoSalida) {
        IngresoSalida nuevoIngresoSalida = ingresoSalidaRepository.save(ingresoSalida);
        return nuevoIngresoSalida;
    }
}
