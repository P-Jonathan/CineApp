package com.sysone.app.service;

import java.util.List;

import com.sysone.app.model.Banner;

public interface IBannerService {

	List<Banner> findAll();

	void guardar(Banner banner);

	void actualizar(Banner banner);

	void eliminar(Banner banner);
}
