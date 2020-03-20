package com.sysone.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sysone.app.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
