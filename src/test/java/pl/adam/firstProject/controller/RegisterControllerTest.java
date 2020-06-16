package pl.adam.firstProject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.adam.firstProject.model.User;
import pl.adam.firstProject.service.RegisterService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(RegisterController.class)
class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RegisterService registerService;

    @Test
    void shouldSayStatusAndViewNameIsOkWhenGetUrlRegister() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

/*    @Test
    void createUser() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/register")
                        .content(new User("trainer11@gmail.com","123"))
                        .contentType(MediaType.TEXT_HTML)
        )
    }*/

}