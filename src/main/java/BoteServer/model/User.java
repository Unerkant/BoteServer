package BoteServer.model;

import jakarta.persistence.*;
import java.util.Set;

/**
 * Den 14.06.2024
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String lastname;
    private String pseudonym;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> role;

    public User(){}

    public User(long id, String username, String lastname, String pseudonym,
                String email, String password, Set<Role> role){
        this.id = id;
        this.username = username;
        this.lastname = lastname;
        this.pseudonym = pseudonym;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getPseudonym() { return pseudonym; }
    public void setPseudonym(String pseudonym) { this.pseudonym = pseudonym; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password;}

    public Set<Role> getRole() { return role; }
    public void setRole(Set<Role> role) { this.role = role; }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", lastname='" + lastname + '\'' +
                ", pseudonym='" + pseudonym + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

}
