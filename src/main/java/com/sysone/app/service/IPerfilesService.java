package com.sysone.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sysone.app.model.Perfil;

public interface IPerfilesService {
	List<Perfil> findAll();
	
	Page<Perfil> findAll(Pageable pageable);

	Perfil findById(int id);

	void save(Perfil perfil);

	void update(Perfil perfil);

	void delete(Perfil perfil);
	
	void deleteById(int id);
}
