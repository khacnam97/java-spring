package net.guides.springboot.registrationlogindemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.guides.springboot.registrationlogindemo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findUserById(long id);
}
