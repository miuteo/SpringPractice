package gs.uploadingFiles.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Asus x556 on 19-May-17.
 */
@ConfigurationProperties("storage")
public class StorageProperties {
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
