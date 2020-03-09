package com.sysone.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sysone.app.model.Noticia;

@Service
public class NoticiasServiceImpl implements INoticiasService {

	private Map<Integer, Noticia> noticias;

	public NoticiasServiceImpl() {
		this.noticias = new HashMap<Integer, Noticia>();
	}

	@Override
	public void guardar(Noticia noticia) {
		System.out.println("Guardando noticia: " + noticia);
		this.noticias.put(noticia.getIdNoticia(), noticia);
	}

	@Override
	public List<Noticia> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Noticia noticia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Noticia noticia) {
		// TODO Auto-generated method stub
		
	}

}
