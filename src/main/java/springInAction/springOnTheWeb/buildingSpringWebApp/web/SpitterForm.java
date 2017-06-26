package springInAction.springOnTheWeb.buildingSpringWebApp.web;

import org.hibernate.validator.constraints.Email;
import org.springframework.web.multipart.MultipartFile;
import springInAction.springOnTheWeb.buildingSpringWebApp.data.Spitter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Asus x556 on 18-Jun-17.
 */
public class SpitterForm {
    @NotNull
    @Size(min=5, max=16, message="{username.size}")
    private String username;

    @NotNull
    @Size(min=5, max=25, message="{password.size}")
    private String password;

    @NotNull
    @Size(min=3, max=16, message="{firstName.size}")
    private String firstName;

    @NotNull
    @Size(min=3, max=16, message="{lastName.size}")
    private String lastName;

    @NotNull
    @Email
    private String email;

    private MultipartFile profilePicture;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MultipartFile getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(MultipartFile profilePicture) {
        this.profilePicture = profilePicture;
    }
    public Spitter toSpitter() {
        return new Spitter(username, password, firstName, lastName, email);
    }

}
