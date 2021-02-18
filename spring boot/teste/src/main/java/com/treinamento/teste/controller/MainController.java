package com.treinamento.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.treinamento.teste.view.Produtos;
import com.treinamento.teste.model.ProdutoRepository;
//@RequestMapping mapeia todas as operações HTTP
@Controller
@RequestMapping(path="/demo") // Isso significa que os URLs começam com / demo (após o caminho do aplicativo)
public class MainController {// isso significa que esta classe é um controlador
	@Autowired // Isso significa obter o bean chamado ProdutosRepository
    // Que é gerado automaticamente pelo Spring, vamos usá-lo para ligar os dados
	 private ProdutoRepository ProdutoRepository;
	 @PostMapping(path="/add") 
	  public @ResponseBody String addNewProduto (@RequestParam String nomeProduto
	      , @RequestParam double valor , @RequestParam long quantidade) {
		// @ResponseBody significa que a string retornada é a resposta, não um nome de visualização
	     // @RequestParam significa que é um parâmetro da solicitação GET ou POST

	    Produtos n = new Produtos();
	    n.setNomeProduto(nomeProduto);
	    n.setValor(valor);
	    n.setQuantidade(quantidade);
	    ProdutoRepository.save(n);
	    return "Salvo com sucesso";
	  }

	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<Produtos> getAllProdutos() {
		// Isso retorna um JSON ou XML com os usuários
	    return ProdutoRepository.findAll();
	  }
}
