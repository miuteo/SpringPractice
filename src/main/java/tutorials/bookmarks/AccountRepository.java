package tutorials.bookmarks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Asus x556 on 20-May-17.
 */
public interface AccountRepository extends JpaRepository<Account,Long>{
    Optional<Account> findByUsername(String username);
}
