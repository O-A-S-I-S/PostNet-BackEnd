package com.api.postnet.repository;

import com.api.postnet.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CitaRepository extends JpaRepository<Cita,Long> {
    @Query("SELECT o From Cita  o WHERE o.pacienteId=?1 ")
    List<Cita>findCitasByPacienteId(String pacienteId);

    Cita findCitaByCitaId(String citaId);
    List<Cita> findCitaByPacienteId(String pacienteId);

    @Query(value="SELECT * from citas o WHERE o.cita_Id=?1",nativeQuery = true)
    Cita findCitaByCitaIdSQLNative(String citaId);

    @Query(value="SELECT * from citas o WHERE o.paciente_Id=?1",nativeQuery = true)
    Cita findCitaByPacienteIdSQLNative(String pacienteId);
}

