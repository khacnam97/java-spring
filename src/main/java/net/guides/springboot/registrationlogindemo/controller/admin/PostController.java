package net.guides.springboot.registrationlogindemo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import net.guides.springboot.registrationlogindemo.dto.PostDto;
import net.guides.springboot.registrationlogindemo.dto.UserDto;
import net.guides.springboot.registrationlogindemo.service.PostService;

@Controller
public class PostController extends BaseController{

	@Autowired
	private PostService postService;
	
	@GetMapping("/post/index")
	public String post(Model model) {
		List<PostDto> posts = postService.findAllPosts();

		model.addAttribute("posts", posts);
		return "admin/post/index";
	}
	
	@GetMapping("/post/create")
	public String create(Model model) {
		PostDto post = new PostDto();
		model.addAttribute("post", post);
		return "admin/post/create";
	}
	
	@PostMapping("/post/save")
	@PreAuthorize("hasRole('admin_1')")
	public String save(@Valid @ModelAttribute("post") PostDto postDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("post", postDto);
			return "admin/post/create";
		}

		postService.savePost(postDto);
		return "redirect:/admin/post/index?success";
	}
	
}
