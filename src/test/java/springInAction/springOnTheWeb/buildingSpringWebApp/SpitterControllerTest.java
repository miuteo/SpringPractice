package springInAction.springOnTheWeb.buildingSpringWebApp;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by Asus x556 on 11-Jun-17.
 */
public class SpitterControllerTest {
    @Test
    public void shouldShowRegistration() throws Exception{
        SpitterRepository mockRepository = Mockito.mock(SpitterRepository.class);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register"))
                .andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }
    @Test
    public void shouldProcessRegistration()throws Exception{
        SpitterRepository mockRepository = Mockito.mock(SpitterRepository.class);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        Spitter unsaved = new Spitter("jbauer","24hours","Jack","Bauer","jack.bauer@gmail.com");
        Spitter saved = new Spitter("jbauer","24hours","Jack","Bauer","jack.bauer@gmail.com");
        Mockito.when(mockRepository.save(unsaved)).thenReturn(saved);

        mockMvc.perform(MockMvcRequestBuilders.post("/spitter/register")
                .param("firstName","Jack")
                .param("lastName","Bauer")
                .param("username","jbauer")
                .param("password","24hours")
                .param("email","jack.bauer@gmail.com")
                ).andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/jbauer/"));
        Mockito.verify(mockRepository,Mockito.atLeastOnce()).save(unsaved);

    }
}
