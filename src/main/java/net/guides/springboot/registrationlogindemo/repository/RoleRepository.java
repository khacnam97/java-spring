package net.guides.springboot.registrationlogindemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.guides.springboot.registrationlogindemo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	 Role findByName(String name);
}
