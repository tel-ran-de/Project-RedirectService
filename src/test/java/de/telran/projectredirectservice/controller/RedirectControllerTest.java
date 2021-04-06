package de.telran.projectredirectservice.controller;

import de.telran.projectredirectservice.service.RedirectService;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import java.util.Optional;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(RedirectController.class)
class RedirectControllerTest {

    @Autowired
    private MockMvc mockMVC;

    @MockBean
    private RedirectService redirectService;

    @Test
    void testRedirectByShortURL() throws Exception {
        String redirectUrl="https://www.google.com/search?q=ostern&rlz=1C5CHFA_enDE898DE898&source=lnms&tbm=isch&sa=X&ved=2ahUKEwin8pnEu-nvAhXXhP0HHT5tABgQ_AUoAXoECAEQBA&biw=1389&bih=697";

        when( redirectService.getRedirectUrl( "798e5d22-8b27-4130-bb59-0b7757186f23" ) )
                .thenReturn( Optional.of( redirectUrl ) );

        MvcResult mvcResult = mockMVC.perform( get( "http://localhost:8090/short_server/798e5d22-8b27-4130-bb59-0b7757186f23" ) )
                .andExpect(status().is3xxRedirection())
                .andExpect(status().isFound())
                .andDo( print() )
                .andExpect( header().string( "Location", redirectUrl ))
                .andReturn();
    }

    @Test
    void testRedirectNotFound() throws Exception {

        when( redirectService.getRedirectUrl( "shortUrlCode" ) )
                .thenReturn( Optional.empty() );

        mockMVC.perform( get( "http://localhost:8090/short_server/shortUrlCode" ) )
                .andExpect(status().isNotFound() )
                .andDo( print() );
    }
}
