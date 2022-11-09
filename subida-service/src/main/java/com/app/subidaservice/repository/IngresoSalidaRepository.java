package com.app.subidaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.subidaservice.entity.IngresoSalida;

@Repository
public interface IngresoSalidaRepository extends JpaRepository<IngresoSalida, Long> {

}
