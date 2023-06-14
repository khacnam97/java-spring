package net.guides.springboot.registrationlogindemo.service;

import java.util.List;

import net.guides.springboot.registrationlogindemo.dto.UserDto;
import net.guides.springboot.registrationlogindemo.entity.Role;
import net.guides.springboot.registrationlogindemo.entity.User;

public interface UserService {
	 void saveUser(UserDto userDto);

	    User findUserByEmail(String email);
	    long deleteUserById(long id);
	    List<UserDto> findAllUsers();

		User get(Long id);

		List<Role> listRoles();

		void save(User user);


		
}
