package com.GrupoDurval.lojadegamesThalita.model;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_usuario")
public class Usuario {
	private @Id @GeneratedValue (strategy = GenerationType.IDENTITY) long id;
	private @NotNull @Size (min = 5, max = 100) String nome;
	private int idade;
	private @ManyToMany (cascade = CascadeType.ALL)
	@JoinTable (name = "USUARIO_PRODUTO", joinColumns = {@JoinColumn(name = "PRODUTO_ID")}, 
	inverseJoinColumns = {@JoinColumn(name = "USUARIO_ID")}) @JsonIgnoreProperties ("Usuario") List<Produto> produto;
	
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
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public List<Produto> getProduto() {
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
}
