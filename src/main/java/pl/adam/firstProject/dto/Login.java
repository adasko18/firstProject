package pl.adam.firstProject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Login {

    @NotBlank(message = "User name is required!")
    private String email;
    @NotBlank(message = "Password is required!")
    private String password;
}
