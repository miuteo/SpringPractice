package springInAction.hittingTheDBwithSpringandJDBC.domain.db.hibernate5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import springInAction.hittingTheDBwithSpringandJDBC.domain.Spitter;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.SpitterRepository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created by teodor.miu on 03-Jul-17.
 */
@Repository
public class HibernateSpitterRepository implements SpitterRepository {

    private SessionFactory sessionFactory;

    @Inject
    public HibernateSpitterRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Inject
    public HibernateSpitterRepository(SessionFactory sessionFactory,int x){
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public Spitter save(Spitter spitter) {
        Serializable id = currentSession().save(spitter);
        return new Spitter((Long) id,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
    }

    @Override
    public Spitter findOne(long id) {
        return currentSession().get(Spitter.class,id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return (Spitter)currentSession()
                .createCriteria(Spitter.class)
                .add(Restrictions.eq("username",username))
                .list().get(0);
    }

    @Override
    public List<Spitter> findAll() {
        return currentSession()
                .createCriteria(Spitter.class).list();
    }
}
