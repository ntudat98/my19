package myapp.controller;

import myapp.service.My19Service;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test")
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = My19Controller.class)
public class My19ControllerTest {

  @MockBean
  My19Service service;


  @Autowired
  private MockMvc mockMvc;


  @Test
  public void getGreeting() throws Exception {

    Mockito.when(service.buildMessage("test-user")).thenReturn("Hello test-user. This is a sample spring boot template project.");

    mockMvc.perform(MockMvcRequestBuilders
      .get("/My19/v1/welcome?name=test-user").header("Authorization", "token"))
      .andExpect(status().isOk());
    Mockito.verify(service, times(1)).buildMessage("test-user");

  }

}
