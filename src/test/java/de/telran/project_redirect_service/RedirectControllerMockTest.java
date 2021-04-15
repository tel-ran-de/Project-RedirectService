package de.telran.project_redirect_service;

import de.telran.project_redirect_service.controller.RedirectController;
import de.telran.project_redirect_service.service.RedirectServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RedirectController.class)
public class RedirectControllerMockTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private RedirectServiceImpl service;


    @Test
    public void testRedirect() throws Exception {
        String redirectUrl = "http://longUrl.com";

        when(service.getRedirectUrl("shorUrl"))
                .thenReturn(Optional.of(redirectUrl));
        System.out.println(LocalDateTime.now());

       mvc.perform(get("/shorUrl"))
                .andExpect(status().is3xxRedirection())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.header().string("Location", redirectUrl))
                .andReturn();

    }

    @Test
    public void testRedirectNotFound() throws Exception {

        when(service.getRedirectUrl("shorUrl"))
                .thenReturn(Optional.empty());

        mvc.perform(get("/shortUrl"))
                .andExpect(status().isNotFound())
                .andDo(print());

    }

}
