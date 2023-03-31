package br.com.samuel.linguagens.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.samuel.linguagens.api.Repository;
import br.com.samuel.linguagens.api.object.Linguagem;

@RestController
public class Controller {
	
	@Autowired
	private Repository repositorio;
	
	@GetMapping("/linguagens")
	public List<Linguagem> listaTudo() {
		return repositorio.findByOrderByRank();
	}
	
	@GetMapping("/linguagens/{id}")
	public Linguagem listaPorId(@PathVariable String id) {
		return repositorio.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/linguagens")
	public Linguagem cadastrar(@RequestBody Linguagem linguagem) {
		return repositorio.save(linguagem);
	}
	
	@PutMapping("/linguagens/{id}")
	public Linguagem atualizar(@PathVariable String id, @RequestBody Linguagem linguagem){
		if(!repositorio.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		linguagem.setId(id);
		return repositorio.save(linguagem);
	}
	
	@DeleteMapping("/linguagens/{id}")
	public void deletar(@PathVariable String id) {
		repositorio.deleteById(id);			
	}
	
	
}
