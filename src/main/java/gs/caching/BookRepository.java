package gs.caching;

public interface BookRepository {
    Book getByIsbn(String isbn);
}
