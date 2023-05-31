package com.fernandolacerda.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandolacerda.workshopmongo.domain.User;
import com.fernandolacerda.workshopmongo.dto.UserDTO;
import com.fernandolacerda.workshopmongo.repository.UserRepository;
import com.fernandolacerda.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		
		return repo.findAll();
		
	}
	
	public User findById(String id) {
		
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
		
	}
	
	public User Insert(User obj) {
		
		return repo.insert(obj);
		
	}
	
	public void delete(String id) {
		
		findById(id);
		repo.deleteById(id);
		
	}
	
	public User update(User obj) {
		
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		
	}
	
	private void updateData(User newObj, User obj) {
		
		newObj.setUser(obj.getUser());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		
		return new User(objDto.getId(), objDto.getUser(), objDto.getEmail());
		
	}
	
}
