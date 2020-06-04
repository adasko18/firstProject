package pl.adam.firstProject;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Register {

    @NotBlank(message = "First name is required!")
    private String firstName;
    @NotBlank(message = "Last name is required!")
    private String lastName;
    @NotBlank(message = "Street name is required!")
    private String street;
    @NotBlank(message = "Home number is required!")
    private String homeNumber;
    @NotBlank(message = "City name is required!")
    private String city;
    @NotBlank(message = "Zip code is required!")
    private String zip;
    @NotBlank(message = "User name is required!")
    private String user;
    @NotBlank(message = "Password is required!")
    private String password;

}
