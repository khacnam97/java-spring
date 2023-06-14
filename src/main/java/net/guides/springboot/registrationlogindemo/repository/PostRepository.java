package net.guides.springboot.registrationlogindemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.guides.springboot.registrationlogindemo.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
}
