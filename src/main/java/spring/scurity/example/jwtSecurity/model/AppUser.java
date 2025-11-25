package spring.scurity.example.jwtSecurity.model;

import jakarta.persistence.*;

@Entity
public class AppUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false,name = "user_name")
    private String username;
    @Column(nullable = false,name = "password")
    private String password;

    private String role;
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getRole()
    {
        return role;
    }
    public void setRole(String role)
    {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
