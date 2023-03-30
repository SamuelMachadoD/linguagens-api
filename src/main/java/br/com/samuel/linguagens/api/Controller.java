package br.com.samuel.linguagens.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	private Repository repositorio;
	
	@GetMapping("/linguagens")
	public List<Linguagem> linguagens() {
		return repositorio.findAll();
	}
	
	@PostMapping("/linguagens")
	public Linguagem cadastrar(@RequestBody Linguagem linguagem) {
		return repositorio.save(linguagem);
	}
}
