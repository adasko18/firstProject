package pl.adam.firstProject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterRequest {

    @NotBlank(message = "User name or Password is required!")
    private String email;
    @NotBlank(message = "User name or Password is required!")
    private String password;

}
