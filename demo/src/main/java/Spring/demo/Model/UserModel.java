package Spring.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name="voters")
public class UserModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String email;
private  String password;

    public UserModel() {
    }

    public UserModel(int id) {
        this.id = id;
    }

    public UserModel(String email) {
        this.email = email;
    }

    public UserModel(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
