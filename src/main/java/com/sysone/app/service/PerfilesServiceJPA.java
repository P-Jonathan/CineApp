package com.sysone.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sysone.app.model.Perfil;
import com.sysone.app.repository.PerfilesRepository;

@Service
public class PerfilesServiceJPA implements IPerfilesService {

	@Autowired
	private PerfilesRepository repo;

	@Override
	public List<Perfil> findAll() {
		return repo.findAll();
	}

	@Override
	public Page<Perfil> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Perfil findById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public void save(Perfil perfil) {
		if (!repo.existsById(perfil.getId()))
			repo.save(perfil);
	}

	@Override
	public void update(Perfil perfil) {
		if (repo.existsById(perfil.getId()))
			repo.save(perfil);
	}

	@Override
	public void delete(Perfil perfil) {
		if (repo.existsById(perfil.getId()))
			repo.delete(perfil);
	}

	@Override
	public void deleteById(int id) {
		if (repo.existsById(id))
			repo.deleteById(id);
	}
}
