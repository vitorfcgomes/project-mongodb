package com.vrzadadev.workshopmongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrzadadev.workshopmongo.domain.Post;
import com.vrzadadev.workshopmongo.repository.PostRepository;
import com.vrzadadev.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired //quando você coloca um anotação dessa o proprio spring procura a definição do objeto e instancia o objeto utilizando automaticamente a injeção de dependencia
	private PostRepository rep;
	
	public Post findById(String id) {
	    return rep.findById(id)
	            .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return rep.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 *60 *60 *1000);
		return rep.fullSearch(text, minDate, maxDate);

	}
}
