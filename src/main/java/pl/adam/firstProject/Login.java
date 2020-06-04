package pl.adam.firstProject;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Login {

    @NotBlank(message = "User name is required!")
    private String user;
    @NotBlank(message = "Password is required!")
    private String password;
}