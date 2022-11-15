package com.app.subidaservice.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.app.subidaservice.entity.IngresoSalida;
import com.app.subidaservice.repository.IngresoSalidaRepository;

@Service
public class IngresoSalidaService {
    @Autowired
    IngresoSalidaRepository ingresoSalidaRepository;

    @Autowired
    FileUploadService fileUploadService;

    public List<IngresoSalida> obtenerIngresosSalidas() {
        return ingresoSalidaRepository.findAll();
    }

    public List<IngresoSalida> obtenerInasistencias() {
        return ingresoSalidaRepository.findInasistencias();
    }

    public List<IngresoSalida> obtenerSalidas() {
        return ingresoSalidaRepository.findSalidas();
    }

    public IngresoSalida obtenerIngresoSalida(Long id) {
        return ingresoSalidaRepository.findById(id).orElse(null);
    }

    public void eliminarIngresosSalidas() {
        ingresoSalidaRepository.deleteAll();
    }

    private IngresoSalida lineaAIngresoSalida(String linea) throws ParseException{
        // Se separa la linea por los ;
        String[] lineaSeparada =  linea.split(";");

        Date fecha = new Date(new SimpleDateFormat("yyyy/MM/dd").parse(lineaSeparada[0]).getTime());
        Time hora  = new Time((new SimpleDateFormat("HH:mm").parse(lineaSeparada[1])).getTime());
        String rut = lineaSeparada[2];

        IngresoSalida ingresoSalida = new IngresoSalida(null, fecha, hora, rut);
        return ingresoSalida;
    }

    public void leerArchivoSubido(String filename){
        try{
            Resource data = fileUploadService.load(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(data.getInputStream()));
            String line = reader.readLine();
            while(line != null){
                ingresoSalidaRepository.save(lineaAIngresoSalida(line));
                line = reader.readLine();
            }
            reader.close();
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
