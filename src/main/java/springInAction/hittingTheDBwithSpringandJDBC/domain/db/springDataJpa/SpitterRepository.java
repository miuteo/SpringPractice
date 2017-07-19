package springInAction.hittingTheDBwithSpringandJDBC.domain.db.springDataJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import springInAction.hittingTheDBwithSpringandJDBC.domain.Spitter;

/**
 * Created by teodor.miu on 04-Jul-17.
 */
public interface SpitterRepository extends JpaRepository<Spitter,Long> {
//    long count();

}
