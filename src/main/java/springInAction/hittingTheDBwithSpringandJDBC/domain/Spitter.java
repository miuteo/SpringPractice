package springInAction.hittingTheDBwithSpringandJDBC.domain;
import javax.persistence.*;

@Entity //hibernate5
public class Spitter {

  @Id//hibernate5
  @GeneratedValue(strategy= GenerationType.IDENTITY)//hibernate5
  private Long id;

  @Column(name="username")//hibernate5
  private String username;

  @Column(name="password")//hibernate5
  private String password;

  @Column(name="fullname")//hibernate5
  private String fullName;

  @Column(name="email")//hibernate5
  private String email;

  @Column(name="updateByEmail")//hibernate5
  private boolean updateByEmail;

  private Spitter(){}//hibernate5

  public Spitter(Long id, String username, String password, String fullName, String email, boolean updateByEmail) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.fullName = fullName;
    this.email = email;
    this.updateByEmail = updateByEmail;
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getFullName() {
    return fullName;
  }

  public String getEmail() {
    return email;
  }

  public boolean isUpdateByEmail() {
    return updateByEmail;
  }

}
