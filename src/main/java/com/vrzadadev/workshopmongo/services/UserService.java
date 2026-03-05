package com.vrzadadev.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrzadadev.workshopmongo.domain.User;
import com.vrzadadev.workshopmongo.dto.UserDTO;
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
	public User insert(User obj) {
		return rep.insert(obj);
	}
	public void Delete(String id) {
		findById(id);
		rep.deleteById(id);
	}
	public User update(User obj) {
	    User newObj = rep.findById(obj.getId())
	        .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	        
	    updateData(newObj, obj);
	    return rep.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
		
	}
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
