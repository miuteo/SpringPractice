package springInAction.springOnTheWeb.buildingSpringWebApp.data;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * Created by teodor.miu on 20-Jun-17.
 */
//@ConfigurationProperties("storage")
public class StorageProperties {
    private String location = "upload-dir/spittr";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}