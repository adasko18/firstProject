package pl.adam.firstProject.service;

import org.springframework.stereotype.Component;
import pl.adam.firstProject.client.PokemonTcgApiClient;
import pl.adam.firstProject.model.Card;
import pl.adam.firstProject.repository.CardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Component
public class BoosterGenerator {

    private CardRepository cardRepository;

    public BoosterGenerator(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> generateCards() {
        List<Card> cards = new ArrayList<>();
        List<Card> allCards = cardRepository.findAll();
        for (int i=0; i<5;i++) {
            cards.add(allCards.get(new Random().nextInt(allCards.size())));
        }
        return cards;
    }
}
