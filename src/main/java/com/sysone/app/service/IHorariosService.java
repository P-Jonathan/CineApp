package com.sysone.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sysone.app.model.Horario;

public interface IHorariosService {
	List<Horario> findAll();
	
	Page<Horario> findAll(Pageable pageable);
	
	List<Horario> findAllAndSortByFecha();

	Horario findById(int id);
	
	List<Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha);

	void save(Horario horario);

	void update(Horario horario);

	void delete(Horario horario);
	
	void deleteById(int idHorario);
}
