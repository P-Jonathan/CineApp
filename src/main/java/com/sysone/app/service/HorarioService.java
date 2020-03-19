package com.sysone.app.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sysone.app.model.Horario;
import com.sysone.app.repository.HorariosRepository;

@Service
public class HorarioService implements IHorariosService {

	@Autowired
	private HorariosRepository horariosRepository;

	@Override
	public List<Horario> findAll() {
		return horariosRepository.findAll();
	}
	
	@Override
	public Horario findById(int id) {
		return horariosRepository.findById(id).get();
	}
	
	@Override
	public List<Horario> findAllAndSortByFecha(){
		return horariosRepository.findAll(Sort.by("fecha").ascending()).stream().collect(Collectors.toList());
	}
	
	@Override
	public List<Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha) {
		return horariosRepository.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);
	}

	@Override
	public void save(Horario horario) {
		if (!horariosRepository.existsById(horario.getId()))
			horariosRepository.save(horario);
	}

	@Override
	public void update(Horario horario) {
		if (horariosRepository.existsById(horario.getId()))
			horariosRepository.save(horario);
	}

	@Override
	public void delete(Horario horario) {
		if (horariosRepository.existsById(horario.getId()))
			horariosRepository.delete(horario);
	}

	@Override
	public void deleteById(int idHorario) {
		if (horariosRepository.existsById(idHorario))
			horariosRepository.deleteById(idHorario);
	}
}
