package com.sysone.app.service;

import java.util.Date;
import java.util.List;

import com.sysone.app.model.Horario;

public interface IHorariosService {
	List<Horario> findAll();
	
	List<Horario> findAllAndSortByFecha();

	Horario findById(int id);
	
	List<Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha);

	void save(Horario horario);

	void update(Horario horario);

	void delete(Horario horario);
	
	void deleteById(int idHorario);
}
