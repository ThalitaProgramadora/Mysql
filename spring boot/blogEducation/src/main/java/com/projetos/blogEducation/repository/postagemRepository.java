package com.projetos.blogEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetos.blogEducation.model.postagem;

@Repository
public interface postagemRepository extends JpaRepository<postagem, Integer> {
	// consulta pelo titulo da postagem
	public List<postagem> findAllByTituloContainingIgnoreCase(String titulo);
}
