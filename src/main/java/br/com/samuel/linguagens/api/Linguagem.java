package br.com.samuel.linguagens.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "principaisLinguagens")
public record Linguagem (
		@Id
		String id, 
		String title, 
		String image, 
		int rank){}
