package models;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

//lombok annnotation:
@Getter
@Setter
@NoArgsConstructor

//jakarta annotation:
@Entity
@Table
public class Hospital implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int hospitalId;
    private String hospitalName;
    private String hospitalAddress;

    public Hospital(String hospitalName, String hospitalAddress) {
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
    }
}
