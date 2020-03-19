package com.sysone.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sysone.app.model.Horario;

public interface HorariosRepository extends JpaRepository<Horario, Integer> {
	List<Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha);
}
