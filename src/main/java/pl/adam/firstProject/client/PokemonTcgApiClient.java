package pl.adam.firstProject.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.adam.firstProject.model.Card;
import pl.adam.firstProject.model.Cards;
import pl.adam.firstProject.repository.CardRepository;

import javax.annotation.PostConstruct;
import java.util.List;
@Component
public class PokemonTcgApiClient {

    private RestTemplate restTemplate;
    private CardRepository cardRepository;

    private static final String URL = "https://api.pokemontcg.io/v1/cards";

    public PokemonTcgApiClient(RestTemplate restTemplate, CardRepository cardRepository) {
        this.restTemplate = restTemplate;
        this.cardRepository = cardRepository;
    }

    @PostConstruct
    public void downloadAllCards() {
        List<Card> allCards = getAllCards();
        cardRepository.saveAll(allCards);
    }

    private List<Card> getAllCards() {
        Cards cards = restTemplate.getForObject(URL, Cards.class);
        return cards.getCards();
    }
}
