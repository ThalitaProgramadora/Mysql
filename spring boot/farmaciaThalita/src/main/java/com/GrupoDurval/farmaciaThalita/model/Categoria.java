package com.GrupoDurval.farmaciaThalita.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.GrupoDurval.farmaciaThalita.model.produto;
@Entity
public class Categoria {
	private @Id @GeneratedValue (strategy = GenerationType.IDENTITY) long id;
	private @NotNull @Size (min = 5, max = 50) String nome;
	private @Size (min = 5, max = 1000) String descricao;
	private @OneToMany (mappedBy = "categoria", cascade = CascadeType.ALL) @JsonIgnoreProperties ("categoria") List<produto> produto;
	
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
	public List<produto> getProduto() {
		return produto;
	}
	public void setProduto(List<produto> produto) {
		this.produto = produto;
	}

}
