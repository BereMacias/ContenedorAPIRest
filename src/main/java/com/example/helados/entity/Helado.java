package com.example.helados.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "heladito")
public class Helado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_helado;
	
	@Column(name="nombre_helado")
	private String nombre_helado;
	
	@Column(name="sabor")
	private String sabor;
	
	@Column(name="tipo_helado")
	private String tipo_helado;
	
	
	public Long getIdHelado() {
		return id_helado;
	}
	public void setIdHelado(Long id_helado) {
		this.id_helado = id_helado;
	}
	public String getNombreHelado() {
		return nombre_helado;
	}
	public void setNombreHelado(String nombre_helado) {
		this.nombre_helado = nombre_helado;
	}
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	public String getTipoHelado() {
		return tipo_helado;
	}
	public void setTipoHelado(String tipo_helado) {
		this.tipo_helado = tipo_helado;
	}

	
}
