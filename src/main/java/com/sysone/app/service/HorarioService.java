package com.sysone.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sysone.app.model.Horario;

@Service
public class HorarioService implements IHorariosService {

	private List<Horario> horarios;

	public HorarioService() {
		this.horarios = new LinkedList<Horario>();
	}

	@Override
	public List<Horario> findAll() {
		return horarios;
	}

	@Override
	public void guardar(Horario horario) {
		horario.setId(horarios.size());
		horarios.add(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Horario horario) {
		// TODO Auto-generated method stub

	}
}
