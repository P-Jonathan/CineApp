package com.sysone.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysone.app.model.Noticia;
import com.sysone.app.repository.NoticiasRepository;

@Service
public class NoticiasServiceJPA implements INoticiasService {

	@Autowired
	private NoticiasRepository noticiasRepository;

	@Override
	public List<Noticia> findAll() {
		return noticiasRepository.findAll();
	}
	
	@Override
	public Noticia findById(int idNoticia) {
		return noticiasRepository.findById(idNoticia).get();
	}

	@Override
	public void save(Noticia noticia) {
		if (!noticiasRepository.existsById(noticia.getId()))
			noticiasRepository.save(noticia);
	}

	@Override
	public void update(Noticia noticia) {
		if (noticiasRepository.existsById(noticia.getId()))
			noticiasRepository.save(noticia);

	}

	@Override
	public void delete(Noticia noticia) {
		if (noticiasRepository.existsById(noticia.getId()))
			noticiasRepository.delete(noticia);
	}

	@Override
	public void deleteByID(int idNoticia) {
		if (noticiasRepository.existsById(idNoticia))
			noticiasRepository.deleteById(idNoticia);
	}
}
