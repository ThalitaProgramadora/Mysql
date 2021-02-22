package com.projetos.blogEducation.controller;

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

import com.projetos.blogEducation.model.postagem;
import com.projetos.blogEducation.repository.postagemRepository;

@RestController
//serve para definir qual é a  uri que vai acessar essa classe, 
//serve para quando for rodar essa classe no postman
@RequestMapping("/postagens")
//quando tiver uma origem de requisição colocamos aqui se saber qual é
//se ainda não sabemos qual é essa origem colocamos o asterisco
@CrossOrigin("*")
public class postagemController {
	// serve para instanciar a interface pelo spring
	@Autowired
	private postagemRepository repository;

	// sempre que vim uma requisição extern atraves da URI
	// for GET dispaa o metodo marcado com o @GetMapping
	@GetMapping
	public ResponseEntity<List<postagem>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<postagem> GetById(@PathVariable int id){
		return (ResponseEntity<postagem>) repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<postagem>> GetByTitulo(@PathVariable String titulo){
		return(ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo)));
	}
	@PostMapping
	public ResponseEntity<postagem> post(@RequestBody postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));		
	}
	@PutMapping
	public ResponseEntity<postagem> put (@RequestBody postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		repository.deleteById(id);
	}
}
