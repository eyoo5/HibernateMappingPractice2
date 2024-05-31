package models;

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
public class Doctor implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int doctorId;
    private String doctorName;

    @ManyToOne
    private Hospital hospital;

    public Doctor(String doctorName, Hospital hospital) {
        super();
        this.doctorName = doctorName;
        this.hospital = hospital;
    }

    //Constructor
    public Doctor( String doctorName) {
        this.doctorName = doctorName;
    }


}
