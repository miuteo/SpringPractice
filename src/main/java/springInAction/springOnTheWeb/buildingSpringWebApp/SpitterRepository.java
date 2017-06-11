package springInAction.springOnTheWeb.buildingSpringWebApp;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Asus x556 on 11-Jun-17.
 */
public interface SpitterRepository extends JpaRepository<Spitter,Long> {
    Spitter findByUsername(String username);
}
