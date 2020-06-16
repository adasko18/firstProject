package pl.adam.firstProject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.adam.firstProject.repository.TrainerRepository;
import pl.adam.firstProject.service.RegisterService;
import pl.adam.firstProject.service.TrainerService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(TrainerController.class)
class TrainerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TrainerRepository trainerRepository;
    @MockBean
    private TrainerService trainerService;

    @Test
    void shouldSayStatusAndViewNameIsOk() throws Exception {
        mockMvc.perform(get("/trainer"))
                .andExpect(status().isOk())
                .andExpect(view().name("trainer"));
    }

}