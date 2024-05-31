package models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

//lombok annnotation:
@Getter
@Setter
@NoArgsConstructor

//jakarta annotation:
@Entity
@Table

public class Specialty implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specialtyId;
    private String specialtyName;

    @OneToMany (targetEntity = Doctor.class, cascade = {CascadeType.ALL})
    private List<Doctor> doctorsList;
    public List<Doctor> getDoctorList(){
        return doctorsList;
    }
    public void setDoctorList(List<Doctor> doctorsList){
        this.doctorsList = doctorsList;
    }


    public Specialty(String specialtyName) {
        this.specialtyName = specialtyName;
    }

}
