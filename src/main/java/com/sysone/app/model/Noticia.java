package com.sysone.app.model;

public class Noticia {
	private String titulo;
	private String estatus;
	private String detalle;

	public Noticia() {
		// constructor vacio;
	}

	public Noticia(String titulo, String estatus, String detalle) {
		super();
		this.titulo = titulo;
		this.estatus = estatus;
		this.detalle = detalle;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
		return "Noticia [titulo=" + titulo + ", estatus=" + estatus + ", detalle=" + detalle + "]";
	}
}
