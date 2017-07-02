package springInAction.hittingTheDBwithSpringandJDBC.domain.db;

import springInAction.hittingTheDBwithSpringandJDBC.domain.Spittle;

import java.util.List;

/**
 * Created by Asus x556 on 01-Jul-17.
 */
public interface SpittleRepository {

    long count();

    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

    Spittle findOne(long id);

    Spittle save(Spittle spittle);

    List<Spittle> findBySpitterId(long spitterId);

    void delete(long id);
}
