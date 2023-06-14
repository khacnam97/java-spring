package net.guides.springboot.registrationlogindemo.service;

import java.util.List;

import jakarta.validation.Valid;
import net.guides.springboot.registrationlogindemo.dto.PostDto;

public interface PostService {
	List<PostDto> findAllPosts();

	void savePost(@Valid PostDto postDto);


}
