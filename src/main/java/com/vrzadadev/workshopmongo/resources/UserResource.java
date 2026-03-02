package com.vrzadadev.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vrzadadev.workshopmongo.domain.User;

@RestController //anotation para falar que é um recurso rest
@RequestMapping(value = "/users") // caminho do endpoint
public class UserResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.ok().body(list); //ok = metodo que vai instanciar o RE já com o código de resposta HTTP(que a resposta ocorreu com sucesso)
											   //body = para definir o corpo da resposta, aqui sendo a lista que montei acima
	}
}
