package pl.adam.firstProject.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
public class TrainerRequest {

    @NotBlank(message = "Nick is required!")
    private String nick;
    @NotBlank(message = "Age is required!")
    private String age;
    @NotBlank(message = "Gender is required!")
    private String gender;
    @NotBlank(message = "Favourite pokemon is required!")
    private String favPokemon;

}
