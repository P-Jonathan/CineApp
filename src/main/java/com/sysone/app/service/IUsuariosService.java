package com.sysone.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sysone.app.model.Usuario;

public interface IUsuariosService {
	List<Usuario> findAll();
	
	Page<Usuario> findAll(Pageable pageable);

	Usuario findById(int id);

	void save(Usuario usuario);

	void update(Usuario usuario);

	void delete(Usuario usuario);
	
	void deleteById(int id);
}
