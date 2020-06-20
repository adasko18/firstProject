package pl.adam.firstProject.model;

import pl.adam.firstProject.dto.TrainerRequest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
public class Trainer {

    @Id
    private String email;

    private String nick;
    private String age;
    private String gender;
    private String favPokemon;
    @ManyToMany
    private List<Card> deck = new ArrayList<>();

    private Trainer() {
    }

    public Trainer(TrainerRequest trainerRequest, String email) {
        this.email = email;
        nick = trainerRequest.getNick();
        age = trainerRequest.getAge();
        gender = trainerRequest.getGender();
        favPokemon = trainerRequest.getFavPokemon();
    }

    public Trainer(String email, String nick, String age, String gender, String favPokemon) {
        this.email = email;
        this.nick = nick;
        this.age = age;
        this.gender = gender;
        this.favPokemon = favPokemon;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void addCards(List<Card> cards) {
        this.deck.addAll(cards);
    }

    public String getNick() {
        return nick;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getFavPokemon() {
        return favPokemon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return Objects.equals(nick, trainer.nick) &&
                Objects.equals(age, trainer.age) &&
                Objects.equals(gender, trainer.gender) &&
                Objects.equals(favPokemon, trainer.favPokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick, age, gender, favPokemon);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "nick='" + nick + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", favPokemon='" + favPokemon + '\'' +
                '}';
    }
}
