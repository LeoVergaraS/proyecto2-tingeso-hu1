package com.app.subidaservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.subidaservice.entity.IngresoSalida;

@Repository
public interface IngresoSalidaRepository extends JpaRepository<IngresoSalida, Long> {
    @Query(value = "SELECT * FROM ingreso_salida i WHERE i.hora > '9:10' and '18:00' > i.hora", nativeQuery = true)
    List<IngresoSalida> findInasistencias();

    @Query(value = "SELECT * FROM ingreso_salida i WHERE i.hora > '18:00' ", nativeQuery = true)
    List<IngresoSalida> findSalidas();

    @Query(value = "SELECT DISTINCT i.rut_empleado FROM ingreso_salida i WHERE i.hora > '8:10' and '9:10' >= i.hora ", nativeQuery = true)
    List<String> findAtrasosRut();

    @Query(value = "SELECT i.fecha FROM ingreso_salida i LIMIT 1", nativeQuery = true)
    String findFecha();

    @Query(value = "SELECT count(*) FROM ingreso_salida i WHERE i.hora > '8:10' and '8:25' >= i.hora and i.rut_empleado = :rut", nativeQuery = true)
    int findAtrasosUno(@Param("rut") String rut);

    @Query(value = "SELECT count(*) FROM ingreso_salida i WHERE i.hora > '8:25' and '8:45' >= i.hora and i.rut_empleado = :rut", nativeQuery = true)
    int findAtrasosDos(@Param("rut") String rut);

    @Query(value = "SELECT count(*) FROM ingreso_salida i WHERE i.hora > '8:45' and '9:10' >= i.hora and i.rut_empleado = :rut", nativeQuery = true)
    int findAtrasosTres(@Param("rut") String rut);

}
