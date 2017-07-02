package springInAction.hittingTheDBwithSpringAndJDBC;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import springInAction.hittingTheDBwithSpringandJDBC.domain.Spitter;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.jdbc.JdbcSpitterRepository;

import java.util.List;


/**
 * Created by Asus x556 on 01-Jul-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JdbcConfig.class)
public class JdbcSpitterRepositoryTest {
    @Autowired
    JdbcSpitterRepository spitterRepository;

    @Test
    public void count() {
        Assert.assertEquals(4, spitterRepository.count());
    }

    @Test
    public void findAll(){
        List<Spitter> spitters = spitterRepository.findAll();
        Assert.assertEquals(4,spitters.size());
        for(int i=0;i<spitters.size();i++){
            assertSpitter(i,spitters.get(i));
        }

    }
    @Test
    public void findOne(){
        assertSpitter(0,spitterRepository.findOne(1));
        assertSpitter(1,spitterRepository.findOne(2));
        assertSpitter(2,spitterRepository.findOne(3));
        assertSpitter(3,spitterRepository.findOne(4));
    }

    @Test
    @Transactional
    public void save_newSpitter(){
        Assert.assertEquals(4,spitterRepository.count());
        Spitter spitter = new Spitter(null, "newbee", "letmein", "New Bee",
                "newbee@habuma.com", true);
        Spitter saved  = spitterRepository.save(spitter);
        Assert.assertEquals(5,spitterRepository.count());
        assertSpitter(4,saved);
        assertSpitter(4,spitterRepository.findOne(5));
    }
    @Test
    @Transactional
    public void save_existingSpitter(){
        Assert.assertEquals(4,spitterRepository.count());
        Spitter spitter = new Spitter(4L, "arthur", "letmein", "Arthur Names",
                "arthur@habuma.com", false);
        Spitter saved  = spitterRepository.save(spitter);
        assertSpitter(5,saved);
        Assert.assertEquals(4,spitterRepository.count());
        Spitter updated = spitterRepository.findOne(4);
        assertSpitter(5,updated);

    }


    private static void assertSpitter(int expectedSpitterIndex,Spitter actual){
        Spitter expected = SPITTERS[expectedSpitterIndex];
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getUsername(), actual.getUsername());
        Assert.assertEquals(expected.getPassword(), actual.getPassword());
        Assert.assertEquals(expected.getFullName(), actual.getFullName());
        Assert.assertEquals(expected.getEmail(), actual.getEmail());
        Assert.assertEquals(expected.isUpdateByEmail(), actual.isUpdateByEmail());
    }

    private static Spitter[] SPITTERS = new Spitter[6];
    @BeforeClass
    public static void before(){
        SPITTERS[0] = new Spitter(1L, "habuma", "password", "Craig Walls",
                "craig@habuma.com", false);
        SPITTERS[1] = new Spitter(2L, "mwalls", "password", "Michael Walls",
                "mwalls@habuma.com", true);
        SPITTERS[2] = new Spitter(3L, "chuck", "password", "Chuck Wagon",
                "chuck@habuma.com", false);
        SPITTERS[3] = new Spitter(4L, "artnames", "password", "Art Names",
                "art@habuma.com", true);
        SPITTERS[4] = new Spitter(5L, "newbee", "letmein", "New Bee",
                "newbee@habuma.com", true);
        SPITTERS[5] = new Spitter(4L, "arthur", "letmein", "Arthur Names",
                "arthur@habuma.com", false);

    }

}
