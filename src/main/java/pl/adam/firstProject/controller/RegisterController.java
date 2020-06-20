package pl.adam.firstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.adam.firstProject.dto.RegisterRequest;
import pl.adam.firstProject.service.RegisterService;
import pl.adam.firstProject.service.RegisterServiceException;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private RegisterService registerService;
    //private PasswordEncoder passwordEncoder;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
        //this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getRegisterPage(Model model) {
        model.addAttribute("register",new RegisterRequest());
        return "register";
    }

    @PostMapping
    public String processRegister(@Valid @ModelAttribute("register") RegisterRequest register, BindingResult errors) {
        System.out.println(register);
        if (errors.hasErrors()) {
            System.out.println("Są błędy");
            return "register";
        }
        try {
            registerService.addUser(register);
        } catch (RegisterServiceException ex) {
            errors.addError(new FieldError("register","email",ex.getMessage()));
            return "register";
        }


        return ("redirect:/login");
    }



}
