package com.app.subidaservice.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ingreso_salida")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngresoSalida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Date fecha;
    private Time hora;
    private String rutEmpleado;
}
