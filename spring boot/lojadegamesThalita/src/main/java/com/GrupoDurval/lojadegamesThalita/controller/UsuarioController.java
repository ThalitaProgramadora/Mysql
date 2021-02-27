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

import com.GrupoDurval.lojadegamesThalita.model.Usuario;
import com.GrupoDurval.lojadegamesThalita.repository.UsuarioRepository;



@RestController
@RequestMapping ("/usuario")
@CrossOrigin ("*")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuario;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll () {
		return ResponseEntity.ok(usuario.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Usuario> getById (@PathVariable long id) {
		return usuario.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/usuario/{nome}")
	public ResponseEntity<List<Usuario>> getByNome (@PathVariable String nome) {
		return ResponseEntity.ok(usuario.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> postUsuario (@RequestBody Usuario nome) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario.save(nome));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> putUsuario (@RequestBody Usuario nome) {
		return ResponseEntity.ok(usuario.save(nome));
	}
	
	@DeleteMapping ("/{id}")
	public void deleteUsuario (@PathVariable long id) {
		usuario.deleteById(id);
	}
}
