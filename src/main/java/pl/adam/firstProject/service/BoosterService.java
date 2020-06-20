package pl.adam.firstProject.service;

import org.springframework.stereotype.Service;
import pl.adam.firstProject.model.Card;
import pl.adam.firstProject.model.Cards;
import pl.adam.firstProject.model.Trainer;
import pl.adam.firstProject.repository.TrainerRepository;

import java.util.List;

@Service
public class BoosterService {

    private TrainerService trainerService;
    private BoosterGenerator boosterGenerator;
    private TrainerRepository trainerRepository;

    public BoosterService(TrainerService trainerService, BoosterGenerator boosterGenerator, TrainerRepository trainerRepository) {
        this.trainerService = trainerService;
        this.boosterGenerator = boosterGenerator;
        this.trainerRepository = trainerRepository;
    }

    public List<Card> openBooster() {
        Trainer trainer = trainerService.getLoggedTrainer();
        List<Card> cards = boosterGenerator.generateCards();

        trainer.addCards(cards);
        trainerRepository.save(trainer);
        return cards;
    }
}
