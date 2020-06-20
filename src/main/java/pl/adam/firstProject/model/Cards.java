package pl.adam.firstProject.model;

import java.util.List;

public class Cards {
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "cards=" + cards +
                '}';
    }
}
