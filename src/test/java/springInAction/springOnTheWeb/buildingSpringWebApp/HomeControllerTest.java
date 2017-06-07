package springInAction.springOnTheWeb.buildingSpringWebApp;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ModelResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;


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

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMVC = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("/resources/template/spittles.html")
                ).build();
        mockMVC.perform(MockMvcRequestBuilders.get("/spittles"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittlesList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittlesList",
                        hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void shouldShowPagedSpittles() throws Exception{
        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(30L,50))
                .thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/resources/template/spittles.html"))
                .build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittles?max=30&count=50"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittlesList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittlesList",
                        hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void testSpittle()throws Exception{
        Spittle expectedSpittle = new Spittle("Hello",new Date());
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);

        Mockito.when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);

        SpittleController controller = new SpittleController((mockRepository));
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittles/12345"))
                .andExpect(MockMvcResultMatchers.view().name("spittle"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittle"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittle",expectedSpittle));


    }

    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles = new ArrayList<>();
        for(int i=0;i<count;i++){
            spittles.add(new Spittle("Spittle "+i,new Date()));
        }
        return spittles;
    }
}
