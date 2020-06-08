package pl.adam.firstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.adam.firstProject.dto.Register;
import pl.adam.firstProject.service.RegisterService;
import pl.adam.firstProject.service.RegisterServiceException;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping
    public String getRegisterPage(Model model) {
        model.addAttribute("register",new Register());
        return "register";
    }

    @PostMapping
    public String processRegister(@Valid Register register, Errors errors) {
        System.out.println(register);
        if (errors.hasErrors()) {
            System.out.println("Są błędy");
            return "register";
        }
        try {
            registerService.addUser(register);
        } catch (RegisterServiceException ex) {
            return "register";
        }


        return ("redirect:/login");
    }



}
