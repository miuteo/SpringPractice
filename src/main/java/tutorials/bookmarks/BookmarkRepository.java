package tutorials.bookmarks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Asus x556 on 20-May-17.
 */
public interface BookmarkRepository extends JpaRepository<Bookmark,Long>{
    Collection<Bookmark> findByAccount_Username(String username);
    Optional<Bookmark> findBookmarkByIdAndAccount_Username(Long id,String username);
}
