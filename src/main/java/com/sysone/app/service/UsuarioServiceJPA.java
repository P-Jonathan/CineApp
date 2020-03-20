package com.sysone.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sysone.app.model.Usuario;
import com.sysone.app.repository.UsuariosRepository;

@Service
public class UsuarioServiceJPA implements IUsuariosService {

	@Autowired
	private UsuariosRepository repo;

	@Override
	public List<Usuario> findAll() {
		return repo.findAll();
	}

	@Override
	public Page<Usuario> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Usuario findById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public void save(Usuario usuario) {
		if (!repo.existsById(usuario.getId()))
			repo.save(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		if (repo.existsById(usuario.getId()))
			repo.save(usuario);
	}

	@Override
	public void delete(Usuario usuario) {
		if (repo.existsById(usuario.getId()))
			repo.delete(usuario);
	}

	@Override
	public void deleteById(int id) {
		if (repo.existsById(id))
			repo.deleteById(id);
	}
}
