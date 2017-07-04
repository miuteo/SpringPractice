package springInAction.hittingTheDBwithSpringAndJDBC;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springInAction.hittingTheDBwithSpringandJDBC.domain.Spittle;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.jpa.JpaSpittleRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by teodor.miu on 04-Jul-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JpaConfig.class)
public class JpaSpittleRepositoryTest {
    @Autowired
    JpaSpittleRepository spittleRepository;
    @Test
    public void count(){
        Assert.assertEquals(15,spittleRepository.count());
    }

    @Test
    public void findRecent(){
        {
            List<Spittle> recent = spittleRepository.findRecent();
            Assert.assertEquals(10,recent.size());
            assertRecent(recent,10);
        }
        {
            List<Spittle> recent = spittleRepository.findRecent(5);
            assertRecent(recent,5);
        }
    }
    @Test
    public void findOne() {
        Spittle thirteen = spittleRepository.findOne(13);
        Assert.assertEquals(13, thirteen.getId().longValue());
        Assert.assertEquals("Bonjour from Art!", thirteen.getMessage());
        Assert.assertEquals(1332682500000L, thirteen.getPostedTime().getTime());
        Assert.assertEquals(4, thirteen.getSpitter().getId().longValue());
        assertEquals("artnames", thirteen.getSpitter().getUsername());
        Assert.assertEquals("password", thirteen.getSpitter().getPassword());
        Assert.assertEquals("Art Names", thirteen.getSpitter().getFullName());
        Assert.assertEquals("art@habuma.com", thirteen.getSpitter().getEmail());
        Assert.assertTrue(thirteen.getSpitter().isUpdateByEmail());
    }

    @Test
    public void findAll(){
        List<Spittle> all = spittleRepository.findAll();
        Assert.assertEquals(15,all.size());
    }




    private void assertRecent(List<Spittle> recent,int count){
        long[] recentIds = new long[] { 3, 2, 1, 15, 14, 13, 12, 11, 10, 9 };
        Assert.assertEquals(count,recent.size());
        for(int i=0;i<count;i++){
            Assert.assertEquals(recentIds[i],recent.get(i).getId().longValue());
        }
    }
    private void assertNewSpittle(Spittle spittle) {
        assertEquals(16, spittle.getId().longValue());
    }
}
