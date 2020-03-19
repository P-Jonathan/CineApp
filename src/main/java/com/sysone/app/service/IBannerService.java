package com.sysone.app.service;

import java.util.List;

import com.sysone.app.model.Banner;

public interface IBannerService {

	List<Banner> findAll();
	
	Banner findById(int idBanner);

	void save(Banner banner);

	void update(Banner banner);

	void delete(Banner banner);
	
	void deleteById(int idBanner);
}
