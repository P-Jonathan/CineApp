package com.sysone.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sysone.app.model.Pelicula;

@Repository
public interface PeliculasRepository extends JpaRepository<Pelicula, Integer> {

}
