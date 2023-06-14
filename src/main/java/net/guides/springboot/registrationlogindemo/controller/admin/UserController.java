package net.guides.springboot.registrationlogindemo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import net.guides.springboot.registrationlogindemo.dto.UserDto;
import net.guides.springboot.registrationlogindemo.entity.Role;
import net.guides.springboot.registrationlogindemo.entity.User;
import net.guides.springboot.registrationlogindemo.service.UserService;

@Controller
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@GetMapping("/users/list")
	@Secured(value = {"ROLE_ADMIN"})
	public String users(Model model, HttpServletRequest request) {
		List<UserDto> users = userService.findAllUsers();
	
		model.addAttribute("users", users);
	
		return "admin/user/list";
	}

	@DeleteMapping("/users/delete/{id}")
	@ResponseBody
	public String deleteUser(@PathVariable long id) throws Exception {
		long userDelete;
		 try {
			 userDelete = userService.deleteUserById(id);
		    } catch (DataAccessException ex) {
		        return ex.toString();
		    }
		    if(userDelete == 0){
		      throw new Exception();
		    }
		return "{\"success\":1}";
	} 


	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable("id") Long id, Model model) {
		 User user = userService.get(id);
	    List<Role> listRoles = userService.listRoles();
	    model.addAttribute("user", user);
	    model.addAttribute("listRoles", listRoles);
		return "admin/user/edit";
	}
	
	@PostMapping("/users/save")
	public String saveUser(User user) {
		userService.save(user);
	     
	    return "redirect:list";
	}
}
