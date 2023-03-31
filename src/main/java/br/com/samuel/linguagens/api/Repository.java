package br.com.samuel.linguagens.api;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.samuel.linguagens.api.object.Linguagem;

public interface Repository extends MongoRepository<Linguagem, String>{
	List<Linguagem> findByOrderByRank();
}
