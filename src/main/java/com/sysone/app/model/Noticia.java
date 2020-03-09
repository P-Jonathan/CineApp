package com.sysone.app.model;

import java.util.Date;

public class Noticia {
	private int idNoticia;
	private String titulo;
	private Date fecha;
	private String estatus;
	private String detalle;

	public Noticia() {
		this.fecha = new Date();
		this.estatus = "Activa";
	}

	public Noticia(String titulo, String estatus, String detalle) {
		this();
		this.titulo = titulo;
		this.estatus = estatus;
		this.detalle = detalle;
	}

	public int getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Noticia [idNoticia=" + idNoticia + ", titulo=" + titulo + ", fecha=" + fecha + ", estatus=" + estatus
				+ ", detalle=" + detalle + "]";
	}
}
