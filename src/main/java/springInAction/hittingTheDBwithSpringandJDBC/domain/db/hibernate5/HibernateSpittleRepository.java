package springInAction.hittingTheDBwithSpringandJDBC.domain.db.hibernate5;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import springInAction.hittingTheDBwithSpringandJDBC.domain.Spittle;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.SpittleRepository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created by teodor.miu on 03-Jul-17.
 */
@Repository
public class HibernateSpittleRepository implements SpittleRepository {
    private SessionFactory sessionFactory;

    @Inject
    public HibernateSpittleRepository(SessionFactory sessionFactory){
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
    public List<Spittle> findRecent() {
        return findRecent(10);
    }

    @Override
    public List<Spittle> findRecent(int count) {
        return spittleCriteria()
                .setMaxResults(count)
                .list();
    }

    @Override
    public Spittle findOne(long id) {
        return currentSession().get(Spittle.class,id);
    }

    @Override
    public Spittle save(Spittle spittle) {
        Serializable id =currentSession().save(spittle);
        return new Spittle(
                (Long) id,
                spittle.getSpitter(),
                spittle.getMessage(),
                spittle.getPostedTime());
    }

    @Override
    public List<Spittle> findBySpitterId(long spitterId) {
        return spittleCriteria().add(Restrictions.eq("spitter.id",spitterId))
                .list();
    }

    @Override
    public List<Spittle> findAll() {
        return currentSession().createCriteria(Spittle.class).list();
    }

    @Override
    public void delete(long id) {
        currentSession().delete(findOne(id));
    }

    private Criteria spittleCriteria(){
        return currentSession().createCriteria(Spittle.class)
                .addOrder(Order.desc("postedTime"));
    }
}
