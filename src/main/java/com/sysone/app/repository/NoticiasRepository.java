package com.sysone.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sysone.app.model.Noticia;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {
	// SELECT * FROM NOTICIAS WHERE ESTATUS = ?
	List<Noticia> findByEstatus(String estatus);

	// SELECT * FROM NOTICIAS WHERE FECHA = ?
	List<Noticia> findByFecha(Date fecha);

	// SELECT * FROM NOTICIAS WHERE ESTATUS = ? AND FECHA = ?
	List<Noticia> findByEstatusAndFecha(String estatus, Date fecha);

	// SELECT * FROM NOTICIAS WHERE ESTATUS = ? OR FECHA = ?
	List<Noticia> findByEstatusOrFecha(String estatus, Date fecha);

	// SELECT * FROM NOTICIAS WHERE FECHA BETWEEN ? AND ?
	List<Noticia> findByFechaBetween(Date fecha1, Date fecha2);

	// SELECT * FROM NOTICIAS WHERE ID BETWEEN ? AND ?
	List<Noticia> findByIdBetween(int id1, int id2);
}
