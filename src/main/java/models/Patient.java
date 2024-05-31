package models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

//lombok annnotation:
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Patient implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    private String name;
    private String address;

    @ManyToMany (targetEntity = Doctor.class)
    private Set <Doctor> doctors;
    public Set <Doctor> getDoctors() {
        return doctors;
    }
    public void setDoctors(Set <Doctor> doctors) {
        this.doctors = doctors;
    }

    public Patient(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Patient (String name, String address, Set <Doctor> doctors) {
        this.name = name;
        this.address = address;
        this.doctors = doctors;
    }

}
