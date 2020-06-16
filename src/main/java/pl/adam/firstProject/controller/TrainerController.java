package pl.adam.firstProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import pl.adam.firstProject.dto.LoginRequest;
import pl.adam.firstProject.dto.TrainerRequest;
import pl.adam.firstProject.model.Trainer;
import pl.adam.firstProject.repository.TrainerRepository;
import pl.adam.firstProject.service.LoginService;
import pl.adam.firstProject.service.LoginServiceException;
import pl.adam.firstProject.service.TrainerService;

import javax.validation.Valid;

@Controller
@RequestMapping("/trainer")
public class TrainerController {

    private TrainerRepository trainerRepository;
    private TrainerService trainerService;

    public TrainerController(TrainerRepository trainerRepository, TrainerService trainerService) {
        this.trainerRepository = trainerRepository;
        this.trainerService = trainerService;
    }

    @GetMapping("")
    public String trainerForm(Model model) {
        model.addAttribute("trainer", new TrainerRequest());
        return "trainer";
    }

    @PostMapping
    public String processTrainerAdding(@Valid @ModelAttribute("trainer") TrainerRequest trainer, Errors errors,
                                       SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "trainer";
        }
        trainerService.addTrainer(trainer);
        sessionStatus.setComplete();

        return "redirect:/";
    }


}
