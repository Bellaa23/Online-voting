package Spring.demo.Model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="voting Table")
public class VoteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer Voter_id;
    private String Name;
    private String email;
    private String gender;
    private String date;
    private String address;
    private String candidates;

    public VoteModel() {
    }

    public VoteModel(Integer id, Integer voter_id, String name, String email, String gender, String date, String address, String candidates) {
        this.id = id;
        Voter_id = voter_id;
        Name = name;
        this.email = email;
        this.gender = gender;
        this.date = date;
        this.address = address;
        this.candidates = candidates;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoter_id() {
        return Voter_id;
    }

    public void setVoter_id(Integer voter_id) {
        Voter_id = voter_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCandidates() {
        return candidates;
    }

    public void setCandidates(String candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return "VoteModel{" +
                "id=" + id +
                ", Voter_id=" + Voter_id +
                ", Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                ", candidates='" + candidates + '\'' +
                '}';
    }
}
