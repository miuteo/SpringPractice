package springInAction.springOnTheWeb.buildingSpringWebApp;

import java.util.List;

/**
 * Created by teodor.miu on 07-Jun-17.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
