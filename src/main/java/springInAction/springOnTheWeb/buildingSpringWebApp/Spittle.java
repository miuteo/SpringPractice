package springInAction.springOnTheWeb.buildingSpringWebApp;

import java.util.Date;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * Created by teodor.miu on 07-Jun-17.
 */
@Entity
public class Spittle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private  String message;
    private  Date time;
    private Double latitude;
    private Double longitude;
    public Spittle(){}

    public Spittle(String message,Date time){
        this(message,time,null,null);
    }
    public Spittle(
       String message,Date time,Double longitude,Double latitude){
        this.id = null;
        this.message =  message;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }
}
