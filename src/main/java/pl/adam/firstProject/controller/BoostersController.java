package pl.adam.firstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.adam.firstProject.service.BoosterService;

@Controller
@RequestMapping("/booster")
public class BoostersController {

    private BoosterService boosterService;

    public BoostersController(BoosterService boosterService) {
        this.boosterService = boosterService;
    }

    @GetMapping
    public String getBoosterPage(Model model) {
        return "booster";
    }

    @PostMapping
    public String openBooster(Model model) {
        model.addAttribute("cards",boosterService.openBooster());
        return ("result");
    }
}
