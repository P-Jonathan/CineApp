package com.sysone.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sysone.app.model.Banner;

@Service
public class BannerServiceImpl implements IBannerService {

	private List<Banner> banners;

	public BannerServiceImpl() {
		this.banners = new LinkedList<Banner>();
		
		
	}

	@Override
	public List<Banner> findAll() {
		return banners;
	}

	@Override
	public void guardar(Banner banner) {
		banner.setId(banners.size());
		banners.add(banner);
	}

	@Override
	public void actualizar(Banner banner) {
	}

	@Override
	public void eliminar(Banner banner) {
	}
}
