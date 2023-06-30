package com.fernandolacerda.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandolacerda.workshopmongo.domain.Post;
import com.fernandolacerda.workshopmongo.repository.PostRepository;
import com.fernandolacerda.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
		
	}
	
	public List<Post> findByTitle(String text){
		
		return repo.searchTitle(text);
		
	}
	
}
