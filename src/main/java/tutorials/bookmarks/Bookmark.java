package tutorials.bookmarks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Asus x556 on 20-May-17.
 */
@Entity
public class Bookmark {
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Account account;

    private String uri;
    private String description;

    Bookmark(){
        //jpa only
    }

    public Bookmark(Account account,String uri,String description){
        this.account = account;
        this.uri = uri;
        this.description =description;
    }

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public String getUri() {
        return uri;
    }

    public String getDescription() {
        return description;
    }
}
