package io.jzheaux.springsecurity.resolutions;

import javax.persistence.*;
import java.util.UUID;

@Entity(name="authorities")
public class UserAuthority {

    @Id
    UUID id;

    @Column
    String authority;

    @JoinColumn(name="username",referencedColumnName = "username")
    @ManyToOne
    User user;

    UserAuthority() {} //default constructor

    public UserAuthority(User user, String authority){

        this.id=UUID.randomUUID();
        this.user=user;
        this.authority=authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public UUID getId() {
        return id;
    }

    public String getAuthority() {
        return authority;
    }
}
