package springInAction.hittingTheDBwithSpringandJDBC.domain.db.springDataJpa;

import springInAction.hittingTheDBwithSpringandJDBC.domain.Spittle;

import java.util.List;

public interface SpittleRepositoryCustom {
    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);
}
