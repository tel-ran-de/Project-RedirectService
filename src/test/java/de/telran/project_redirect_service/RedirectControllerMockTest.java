package de.telran.project_redirect_service;

import de.telran.project_redirect_service.controller.RedirectController;
import de.telran.project_redirect_service.service.RedirectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RedirectController.class)
public class RedirectControllerMockTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private RedirectService service;


    //Status = 200 - don't ok
    @Test
    public void testRedirect() throws Exception {
        when(service.getRedirectUrl("http:/short"))
                .thenReturn(Optional.empty());

        mvc.perform(get("/short")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(redirectedUrl("http:/shortf"))
                .andExpect(status().is3xxRedirection())
                .andDo(print());
    }


    //Status = 404 - all ok
    @Test
    public void testRedirectNotFound() throws Exception {

        when(service.getRedirectUrl(""))
                .thenReturn(Optional.empty());

        mvc.perform(get("/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());

    }

}
