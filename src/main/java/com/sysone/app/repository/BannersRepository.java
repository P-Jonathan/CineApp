package com.sysone.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sysone.app.model.Banner;

public interface BannersRepository extends JpaRepository<Banner, Integer> {

}
