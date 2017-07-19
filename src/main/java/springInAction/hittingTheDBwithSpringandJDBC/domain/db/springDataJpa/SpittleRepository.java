package springInAction.hittingTheDBwithSpringandJDBC.domain.db.springDataJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springInAction.hittingTheDBwithSpringandJDBC.domain.Spitter;
import springInAction.hittingTheDBwithSpringandJDBC.domain.Spittle;

import java.util.List;

/**
 * Created by teodor.miu on 04-Jul-17.
 */
public interface SpittleRepository extends JpaRepository<Spittle,Long>, SpittleRepositoryCustom {
    List<Spittle> findBySpitterId(long spitterId);
}
