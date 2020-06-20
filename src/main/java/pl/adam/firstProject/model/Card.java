package pl.adam.firstProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Card {
    @Id
    private String id;
    private String name;
    private int nationalPokedexNumber;
    private String imageUrl;
    private String rarity;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNationalPokedexNumber() {
        return nationalPokedexNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getRarity() {
        return rarity;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nationalPokedexNumber=" + nationalPokedexNumber +
                ", imageUrl='" + imageUrl + '\'' +
                ", rarity='" + rarity + '\'' +
                '}';
    }
}
