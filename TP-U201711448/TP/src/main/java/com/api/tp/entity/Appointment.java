package com.api.tp.entity;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name="cita_Medica")
@Inheritance(strategy = InheritanceType.JOINED)
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="fecha")
    private Date date;

}
