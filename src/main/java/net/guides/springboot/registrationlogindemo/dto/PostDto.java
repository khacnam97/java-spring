package net.guides.springboot.registrationlogindemo.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

	private Long id;
	@NotEmpty(message = "Title should not be empty")
    private String title;
	@NotEmpty(message = "Content should not be empty")
    private String content;

    private Long userId;
    private String userName;
}
