package springInAction.hittingTheDBwithSpringandJDBC.domain.db.jpa;


import org.springframework.stereotype.Repository;
import springInAction.hittingTheDBwithSpringandJDBC.domain.Spitter;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.SpitterRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Asus x556 on 03-Jul-17.
 */
@Repository
public class JpaSpitterRepository implements SpitterRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public Spitter save(Spitter spitter) {
        if(spitter!=null){

            if(spitter.getId()==null){
                entityManager.persist(spitter);
            }else{
                entityManager.merge(spitter);
            }
        }
        return spitter;
    }

    @Override
    public Spitter findOne(long id) {
        return entityManager.find(Spitter.class,id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return (Spitter) entityManager.createQuery("select s from Spitter s where s.username=?")
                .setParameter(1,username).getSingleResult();
    }

    @Override
    public List<Spitter> findAll() {
        return (List<Spitter>) entityManager.createQuery("select s from Spitter s").getResultList();
    }
}
