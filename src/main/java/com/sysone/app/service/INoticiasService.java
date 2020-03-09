package com.sysone.app.service;

import java.util.List;

import com.sysone.app.model.Noticia;

public interface INoticiasService {
	List<Noticia> listar();
	
	void guardar(Noticia noticia);
	
	void actualizar(Noticia noticia);
	
	void eliminar(Noticia noticia);
}
