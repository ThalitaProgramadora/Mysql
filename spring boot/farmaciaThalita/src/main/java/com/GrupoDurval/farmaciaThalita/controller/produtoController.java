package com.GrupoDurval.farmaciaThalita.controller;
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

import com.GrupoDurval.farmaciaThalita.model.produto;
import com.GrupoDurval.farmaciaThalita.repository.produtoRepository;

@RestController
@RequestMapping ("/produto")
@CrossOrigin ("*")
public class produtoController {
	@Autowired
	private produtoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<produto>> getAll (String nome) {
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<produto> getById (@PathVariable long id) {
		return produtoRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/produto/{nome}")
	public ResponseEntity<List<produto>> getByNome (@PathVariable String nome) {
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<produto> postProduto (@RequestBody produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<produto> putProduto (@RequestBody produto produto) {
		return ResponseEntity.ok(produtoRepository.save(produto));
	}
	
	@DeleteMapping ("/{id}")
	public void deleteProduto (@PathVariable long id) {
		produtoRepository.deleteById(id);
	}
}
