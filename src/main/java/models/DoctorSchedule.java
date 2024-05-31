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
public class DoctorSchedule implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorScheduleId;
    private String reasonForVisit;
    private String dateTime;

    @OneToOne (cascade = CascadeType.ALL)
    private Doctor doctor;


    public DoctorSchedule(String reasonForVisit, String dateTime) {
        this.reasonForVisit = reasonForVisit;
        this.dateTime = dateTime;
    }

}
