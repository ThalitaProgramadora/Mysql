package com.projetos.blogEducation.model;

import java.awt.TextArea;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class postagem {
	// serve para ideintificar a chave primaria da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id int id;
	@NotNull
	@Size(min = 5, max = 20)
	private String titulo;
	@NotNull
	@Size(min = 15, max = 1000)
	private TextArea Texto;
	// serve para pegar a data e hora de quando foi salvo ou criado algo.
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new java.sql.Date(System.currentTimeMillis());

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TextArea getTexto() {
		return Texto;
	}

	public void setTexto(TextArea texto) {
		Texto = texto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
