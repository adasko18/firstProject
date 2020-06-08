package pl.adam.firstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.adam.firstProject.dto.Login;
import pl.adam.firstProject.dto.Register;
import pl.adam.firstProject.service.LoginService;
import pl.adam.firstProject.service.LoginServiceException;
import pl.adam.firstProject.service.RegisterService;
import pl.adam.firstProject.service.RegisterServiceException;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String getLoginPage(Model model) {
        model.addAttribute("login",new Login());
        return "login";
    }

    @PostMapping
    public String processLogin(@Valid Login login, BindingResult errors) {
        System.out.println(login);
        if (errors.hasErrors()) {
            System.out.println("Są błędy");
            return "login";
        }
        try {
            loginService.logIn(login);
        } catch (LoginServiceException ex) {
            errors.addError(new FieldError("login",ex.getForField(),ex.getMessage()));
            return "login";
        }


        return ("redirect:/login");
    }
}
