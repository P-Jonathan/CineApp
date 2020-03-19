package com.sysone.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysone.app.model.Banner;
import com.sysone.app.repository.BannersRepository;

@Service
public class BannerServiceJPA implements IBannerService {

	@Autowired
	private BannersRepository bannersRepository;

	@Override
	public List<Banner> findAll() {
		return bannersRepository.findAll();
	}

	@Override
	public Banner findById(int idBanner) {
		return bannersRepository.findById(idBanner).get();
	}

	@Override
	public void save(Banner banner) {
		if (!bannersRepository.existsById(banner.getId()))
			bannersRepository.save(banner);
	}

	@Override
	public void update(Banner banner) {

		if (bannersRepository.existsById(banner.getId()))
			bannersRepository.save(banner);
	}

	@Override
	public void delete(Banner banner) {
		if (bannersRepository.existsById(banner.getId()))
			bannersRepository.deleteById(banner.getId());
	}

	@Override
	public void deleteById(int idBanner) {
		if (bannersRepository.existsById(idBanner))
			bannersRepository.deleteById(idBanner);
	}
}
