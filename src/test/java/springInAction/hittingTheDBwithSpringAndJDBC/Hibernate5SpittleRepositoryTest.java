package springInAction.hittingTheDBwithSpringAndJDBC;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import springInAction.hittingTheDBwithSpringandJDBC.domain.Spitter;
import springInAction.hittingTheDBwithSpringandJDBC.domain.Spittle;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.SpittleRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Asus x556 on 03-Jul-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Hibernate5Config.class)
public class Hibernate5SpittleRepositoryTest {
    @Autowired
    SpittleRepository spittleRepository;

    @Test
    @Transactional
    public void count() {
        Assert.assertEquals(15, spittleRepository.count());
    }
    @Test
    @Transactional
    public void findRecent(){
        //default case
        {
            List<Spittle> spittles = spittleRepository.findRecent();
            assertRecent(spittles,10);
        }
        //specific count case
        {
            List<Spittle> spittles = spittleRepository.findRecent(5);
            assertRecent(spittles,5);
        }
    }

    @Test
    @Transactional
    public void findOne(){
        Spittle thirteen = spittleRepository.findOne(13);//gasirea spittle-ului cu id 13
        Assert.assertEquals(13,thirteen.getId().longValue());//        assertEquals(13, thirteen.getId().longValue());
        Assert.assertEquals("Bonjour from Art!", thirteen.getMessage());
        Assert.assertEquals(1332682500000L, thirteen.getPostedTime().getTime());
        Assert.assertEquals(4, thirteen.getSpitter().getId().longValue());
        Assert.assertEquals("artnames", thirteen.getSpitter().getUsername());
        Assert.assertEquals("password", thirteen.getSpitter().getPassword());
        Assert.assertEquals("Art Names", thirteen.getSpitter().getFullName());
        Assert.assertEquals("art@habuma.com", thirteen.getSpitter().getEmail());
        Assert.assertTrue(thirteen.getSpitter().isUpdateByEmail());
    }


    @Test
    @Transactional
    public void findBySpitter(){
        List<Spittle> spittles = spittleRepository.findBySpitterId(4);//gasirea listei de spittles ce au fost facut de spitter-ul cu id-ul 4
        Assert.assertEquals(11,spittles.size());//trebuie sa fie 11
        for (int i = 0; i < 11; i++) {
            Assert.assertEquals(15-i, spittles.get(i).getId().longValue());
        }
    }
    @Test
    @Transactional
    public void save(){
        Assert.assertEquals(15,spittleRepository.count());//verificare in db sa fie 15
//        List<Spittle> spittles= spittleRepository.findBySpitterId(13);//spitter si spittle(spittle cu id=13)
        Spitter spitter = spittleRepository.findOne(13).getSpitter();
        Spittle spittle = new Spittle(null, spitter, "Un Nuevo Spittle from Art", new Date());
        Spittle saved = spittleRepository.save(spittle);
        Assert.assertEquals(16,spittleRepository.count());//verificare in db ca sunt 16
        Assert.assertEquals(16,saved.getId().longValue());//saved sa aibe id-ul 16(atat din db cat si din ce avem noi returnat


    }
    @Test
    @Transactional
    public void delete(){
        Assert.assertEquals(15,spittleRepository.count());//varificare in db ca sunt 15
        Assert.assertNotNull(spittleRepository.findOne(13));//spittle cu id=13 sa nu fie null
        spittleRepository.delete(13);//stergere spittle cu idul =13
        Assert.assertEquals(14,spittleRepository.count());//verificare in db ca sunt 14
        Assert.assertNull(spittleRepository.findOne(13));//verificare sa fie null spittle cu id-ul 13

    }
    private void assertRecent(List<Spittle> recent, int count) {
        long[] recentIds = new long[] {3,2,1,15,14,13,12,11,10,9};
        Assert.assertEquals(count, recent.size());
        for (int i = 0; i < count; i++) {
            Assert.assertEquals(recentIds[i], recent.get(i).getId().longValue());
        }
    }
}

