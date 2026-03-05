package com.vrzadadev.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vrzadadev.workshopmongo.domain.Post;
import com.vrzadadev.workshopmongo.services.PostService;

@RestController // anotation para falar que é um recurso rest
@RequestMapping(value = "/posts") // caminho do endpoint
public class PostResource {

	@Autowired // controlador REST acessa o serviço
	private PostService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
