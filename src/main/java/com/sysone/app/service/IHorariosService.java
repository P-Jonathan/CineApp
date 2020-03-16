package com.sysone.app.service;

import java.util.List;

import com.sysone.app.model.Horario;

public interface IHorariosService {
	List<Horario> findAll();

	void guardar(Horario horario);

	void actualizar(Horario horario);

	void eliminar(Horario horario);
}
