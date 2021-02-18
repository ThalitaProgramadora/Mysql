package com.treinamento.teste.model;
import org.springframework.data.repository.CrudRepository;

import com.treinamento.teste.view.Produtos;
//Isso será AUTO IMPLEMENTADO pelo Spring em um Bean chamado ProdutoRepository
//CRUD refere-se a Criar, Ler, Atualizar, Excluir
public interface ProdutoRepository extends CrudRepository<Produtos,Integer>{

}
