package com.GrupoDurval.lojadegamesThalita.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GrupoDurval.lojadegamesThalita.model.Produto;
import com.GrupoDurval.lojadegamesThalita.repository.ProdutoRepository;


@RestController
@RequestMapping ("/produto")
@CrossOrigin ("*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produto;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll () {
		return ResponseEntity.ok(produto.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Produto> getById (@PathVariable long id) {
		return produto.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("produto/{titulo}")
	public ResponseEntity<List<Produto>> getByTitulo (@PathVariable String titulo) {
		return ResponseEntity.ok(produto.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Produto> postTitulo (@RequestBody Produto post) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produto.save(post));
	}
	
	@PutMapping
	public ResponseEntity<Produto> putTitulo (@RequestBody Produto put) {
		return ResponseEntity.ok(produto.save(put));
	}
	
	@DeleteMapping ("/{id}")
	public void deleteTitulo (@PathVariable long id) {
		produto.deleteById(id);
	}
}
