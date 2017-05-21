package tutorials.bookmarks;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Asus x556 on 21-May-17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookmarkNotFoundException extends RuntimeException{
    BookmarkNotFoundException(Long bookmarkId){
        super("Bookmark with id ="+bookmarkId+" not found");
    }
    BookmarkNotFoundException(String userName,Long bookmarkId){
        super("Bookmark for username="+userName+" with id ="+bookmarkId+" not found");
    }
}
