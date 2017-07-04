package springInAction.hittingTheDBwithSpringandJDBC.domain.db.jpa;

import org.springframework.stereotype.Repository;
import springInAction.hittingTheDBwithSpringandJDBC.domain.Spittle;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.SpittleRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Asus x556 on 03-Jul-17.
 */
@Repository
public class JpaSpittleRepository implements SpittleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public List<Spittle> findRecent() {
        return findRecent(10);
    }

    @Override
    public List<Spittle> findRecent(int count) {
        return (List<Spittle>) entityManager.createQuery("select s from Spittle s order by s.postedTime desc")
                .setMaxResults(count).getResultList();
    }

    @Override
    public Spittle findOne(long id) {
        return entityManager.find(Spittle.class,id);
    }

    @Override
    public Spittle save(Spittle spittle) {
        if(spittle!=null){
            if(spittle.getId()==null){
                entityManager.persist(spittle);
            }else{
                entityManager.merge(spittle);
            }
        }

        return spittle;
    }

    @Override
    public List<Spittle> findBySpitterId(long spitterId) {
        return (List<Spittle>)entityManager.createQuery("select s from Spittles s,Spitter sp " +
                "where s.spitter = sp and sp.id=? " +
                "order by s.postedTime desc").setParameter(1,spitterId)
                .getResultList();
    }

    @Override
    public List<Spittle> findAll() {
        return (List<Spittle>) entityManager.createQuery("select s from Spittle s")
                .getResultList();
    }

    @Override
    public void delete(long id) {
        entityManager.remove(findOne(id));
    }
}
