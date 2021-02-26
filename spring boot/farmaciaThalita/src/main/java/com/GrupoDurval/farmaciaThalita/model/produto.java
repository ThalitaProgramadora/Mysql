package com.GrupoDurval.farmaciaThalita.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class produto {
	private @Id @GeneratedValue (strategy = GenerationType.IDENTITY) long id;
	private @NotNull @Size (min = 5, max = 100) String nome;
	private @Size (min = 15, max = 1000) String descricao;
	private @ManyToOne @JsonIgnoreProperties ("produto") Categoria categoria;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
