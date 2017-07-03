package springInAction.hittingTheDBwithSpringandJDBC.domain;

import javax.persistence.*;
import java.util.Date;

@Entity//hibernate5
public class Spittle {
  @Id//hibernate5
  @GeneratedValue(strategy= GenerationType.IDENTITY)//hibernate5
  private  Long id;

  @ManyToOne//hibernate5
  @JoinColumn(name="spitter")//hibernate5
  private  Spitter spitter;

  @Column//hibernate5
  private  String message;

  @Column//hibernate5
  private  Date postedTime;

  private Spittle(){}//hibernate5
  public Spittle(Long id, Spitter spitter, String message, Date postedTime) {
    this.id = id;
    this.spitter = spitter;
    this.message = message;
    this.postedTime = postedTime;
  }
  
  public Long getId() {
    return this.id;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public Date getPostedTime() {
    return this.postedTime;
  }

  public Spitter getSpitter() {
    return this.spitter;
  }

}
