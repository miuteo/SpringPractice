package springInAction.springOnTheWeb.buildingSpringWebApp;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


/**
 * Created by teodor.miu on 06-Jun-17.
 */
public class HomeControllerTest {
    @Test
    public void testHomePage()throws Exception{
        HomeController controller = new HomeController();
        MockMvc mockMvc  = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.view().name("home"));
    }
}
