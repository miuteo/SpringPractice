package springInAction.springOnTheWeb.buildingSpringWebApp;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


/**
 * Created by teodor.miu on 06-Jun-17.
 */
public class HomeControllerTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    @Test
    public void testHomePage()throws Exception{
        HomeController controller = new HomeController();
        MockMvc mockMvc  = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.view().name("home"));
    }

    @Test
    public void shouldShowRecentSpittles()throws Exception{
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);


        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE,20))
                .thenReturn(expectedSpittles);

//        SpittleC

    }

    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles = new ArrayList<>();
        for(int i=0;i<count;i++){
            spittles.add(new Spittle("Spittle "+i,new Date()));
        }
        return spittles;
    }
}
