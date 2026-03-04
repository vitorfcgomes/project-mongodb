package com.vrzadadev.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrzadadev.workshopmongo.domain.User;
import com.vrzadadev.workshopmongo.repository.UserRepository;
import com.vrzadadev.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired //quando você coloca um anotação dessa o proprio spring procura a definição do objeto e instancia o objeto utilizando automaticamente a injeção de dependencia
	private UserRepository rep;
	
	public List<User> findAll(){
		return rep.findAll();
	}
	public User findById(String id) {
	    return rep.findById(id)
	            .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
