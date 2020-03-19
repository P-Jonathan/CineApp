package com.sysone.app.service;

import java.util.List;

import com.sysone.app.model.Noticia;

public interface INoticiasService {
	List<Noticia> findAll();

	Noticia findById(int id);
	
	void save(Noticia noticia);
	
	void update(Noticia noticia);
	
	void delete(Noticia noticia);
	
	void deleteByID(int idNoticia);
}
