package springInAction.hittingTheDBwithSpringandJDBC.domain.db;

import springInAction.hittingTheDBwithSpringandJDBC.domain.Spitter;

import java.util.List;

/**
 * Created by Asus x556 on 01-Jul-17.
 */
public interface SpitterRepository {
    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}
