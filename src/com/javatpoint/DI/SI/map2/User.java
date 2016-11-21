package com.javatpoint.DI.SI.map2;

/**
 * Created by Ionela on 11/21/2016.
 */
public class User {
    private int id;
    private String name,email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
