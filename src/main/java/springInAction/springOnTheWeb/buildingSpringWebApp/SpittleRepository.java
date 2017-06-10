package springInAction.springOnTheWeb.buildingSpringWebApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by teodor.miu on 07-Jun-17.
 */
public interface SpittleRepository extends JpaRepository<Spittle,Long> {
    @Query(value="select i from Spittle i where i.id< :max and :count= :count")
    List<Spittle> findSpittles(@Param("max")long max, @Param("count")int count);

    Spittle findOne(long id);
}
