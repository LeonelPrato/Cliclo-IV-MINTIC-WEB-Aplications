package co.edu.mintic.ciclo4.minticciclo4.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(length = 11)
    private Integer id;

    @NotBlank(message = "Email is mandatory")
    @Column(length = 50)
    @Size(min = 5, max = 50)
    private String email;

    @NotBlank(message = "Name is mandatory")
    @Column(length = 80)
    @Size(min = 1, max = 80)
    private String name;

    @NotBlank(message = "Password is mandatory")
    @Column(length = 80)
    @Size(min = 1, max = 80)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
