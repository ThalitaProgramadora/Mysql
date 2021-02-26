package com.GrupoDurval.farmaciaThalita.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.GrupoDurval.farmaciaThalita.model.produto;
public interface produtoRepository extends JpaRepository<produto, Long>{
	public List<produto> findAllByNomeContainingIgnoreCase (String nome);
}
