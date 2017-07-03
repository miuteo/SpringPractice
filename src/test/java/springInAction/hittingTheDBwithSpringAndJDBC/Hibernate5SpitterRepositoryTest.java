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
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.SpitterRepository;


import java.util.List;

/**
 * Created by teodor.miu on 03-Jul-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Hibernate5Config.class)
public class Hibernate5SpitterRepositoryTest {

    @Autowired
    SpitterRepository spitterRepository;

    @Test
    @Transactional
    public void count() {
        Assert.assertEquals(4, spitterRepository.count());
    }

    @Test
    @Transactional
    public void findAll(){
        List<Spitter> spitters = spitterRepository.findAll();
        Assert.assertEquals(4,spitters.size());//verufucare sa fie sizeul 4
        for(int i=0;i<4;i++){
            assertSpitter(i,spitters.get(i));
        }
    }

    private static void assertSpitter(int expectedSpitterIndex, Spitter actual) {
        Spitter expected = SPITTERS[expectedSpitterIndex];
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getUsername(), actual.getUsername());
        Assert.assertEquals(expected.getPassword(), actual.getPassword());
        Assert.assertEquals(expected.getFullName(), actual.getFullName());
        Assert.assertEquals(expected.getEmail(), actual.getEmail());
        Assert.assertEquals(expected.isUpdateByEmail(), actual.isUpdateByEmail());
    }
    @Test
    @Transactional
    public void findByUsername() {
        assertSpitter(0, spitterRepository.findByUsername("habuma"));
        assertSpitter(1, spitterRepository.findByUsername("mwalls"));
        assertSpitter(2, spitterRepository.findByUsername("chuck"));
        assertSpitter(3, spitterRepository.findByUsername("artnames"));
    }

    @Test
    @Transactional
    public void findOne() {
        assertSpitter(0, spitterRepository.findOne(1L));
        assertSpitter(1, spitterRepository.findOne(2L));
        assertSpitter(2, spitterRepository.findOne(3L));
        assertSpitter(3, spitterRepository.findOne(4L));
    }
    @Test
    @Transactional
    public void save_newSpitter(){
        Assert.assertEquals(4,spitterRepository.count());
        Spitter spitter = new Spitter(null, "newbee", "letmein", "New Bee",
                "newbee@habuma.com", true);
        Spitter savedSpitter =spitterRepository.save(spitter); //salvarea lui spitter
        Assert.assertEquals(5,spitterRepository.count());//verificare ca in db sunt 5
        assertSpitter(4,savedSpitter);//verificare ca pe pozitia 4 este saved
        assertSpitter(4,spitterRepository.findOne(5));//verificare ca pe pozidita 4 este din spitter cu id=5 din db
    }

    private static Spitter[] SPITTERS = new Spitter[6];

    @BeforeClass
    public static void before() {
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
