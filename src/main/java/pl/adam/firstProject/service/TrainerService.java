package pl.adam.firstProject.service;

import org.springframework.stereotype.Service;
import pl.adam.firstProject.dto.RegisterRequest;
import pl.adam.firstProject.dto.TrainerRequest;
import pl.adam.firstProject.model.Trainer;
import pl.adam.firstProject.model.User;
import pl.adam.firstProject.repository.TrainerRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class TrainerService {

    private LoginService loginService;
    private TrainerRepository trainerRepository;

    public TrainerService(LoginService loginService, TrainerRepository trainerRepository) {
        this.loginService = loginService;
        this.trainerRepository = trainerRepository;
    }

    public void addTrainer(TrainerRequest trainerRequest) {
        validateDontHaveTrainer();
        Trainer trainer = new Trainer(trainerRequest, loginService.getLoggedUser().getEmail());
        trainerRepository.save(trainer);
    }

    private void validateDontHaveTrainer() {
        Optional<Trainer> trainer = trainerRepository.findById(loginService.getLoggedUser().getEmail());
        if (trainer.isPresent()) {
            throw new TrainerServiceException("Trainer cannot be added");
        }

        }
    }

