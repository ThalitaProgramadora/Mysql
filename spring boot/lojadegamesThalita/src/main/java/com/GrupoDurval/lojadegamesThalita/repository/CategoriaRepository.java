package com.GrupoDurval.lojadegamesThalita.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GrupoDurval.lojadegamesThalita.model.Categoria;
@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long>{
	public List<Categoria> findAllByDescricaoContainingIgnoreCase (String descricao);
}
