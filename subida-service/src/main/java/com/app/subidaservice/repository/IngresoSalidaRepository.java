package com.app.subidaservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.subidaservice.entity.IngresoSalida;

@Repository
public interface IngresoSalidaRepository extends JpaRepository<IngresoSalida, Long> {
    @Query(value = "SELECT * FROM ingreso_salida i WHERE i.hora > '9:10' and '18:00' > i.hora", nativeQuery = true)
    public List<IngresoSalida> findInasistencias();

    @Query(value = "SELECT * FROM ingreso_salida i WHERE i.hora > '18:00' ", nativeQuery = true)
    public List<IngresoSalida> findSalidas();
}
