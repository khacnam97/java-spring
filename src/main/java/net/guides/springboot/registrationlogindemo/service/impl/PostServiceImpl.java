package net.guides.springboot.registrationlogindemo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import net.guides.springboot.registrationlogindemo.dto.PostDto;
import net.guides.springboot.registrationlogindemo.entity.Post;
import net.guides.springboot.registrationlogindemo.entity.User;
import net.guides.springboot.registrationlogindemo.repository.PostRepository;
import net.guides.springboot.registrationlogindemo.repository.UserRepository;
import net.guides.springboot.registrationlogindemo.security.CustomUserDetails;
import net.guides.springboot.registrationlogindemo.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepository;
	private UserRepository userRepository;
	
	public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<PostDto> findAllPosts() {
		List<Post> posts = postRepository.findAll();
		return posts.stream().map((post) -> mapToPostDto(post)).collect(Collectors.toList());
	}

	private PostDto mapToPostDto(Post post) {
		PostDto postDto = new PostDto();
		postDto.setContent(post.getContent());
		postDto.setTitle(post.getTitle());
		postDto.setId(post.getId());
        User user =  userRepository.findUserById(post.getUserId());        
		postDto.setUserName(user.getName());
		return postDto;
	}

	@Override
	public void savePost(@Valid PostDto postDto) {
		CustomUserDetails myUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long userId=myUserDetails.getId(); 
		
		System.out.println("user id : " + userId);
		Post post = new Post();
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setUserId(userId);
		postRepository.save(post);
	}

}
