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

import com.GrupoDurval.lojadegamesThalita.model.Categoria;
import com.GrupoDurval.lojadegamesThalita.repository.CategoriaRepository;


@RestController
@RequestMapping ("/categoria")
@CrossOrigin ("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoria;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll () {
		return ResponseEntity.ok(categoria.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Categoria> getById (@PathVariable long id) {
		return categoria.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/categoria/{descricao}")
	public ResponseEntity<List<Categoria>> getByDescricao (@PathVariable String descricao) {
		return ResponseEntity.ok(categoria.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> postCategoria (@RequestBody Categoria post) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoria.save(post));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putCategoria (@RequestBody Categoria put) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoria.save(put));
	}
	
	@DeleteMapping ("/{id}")
	public void deleteById (@PathVariable long id) {
		categoria.deleteById(id);
	}
}
