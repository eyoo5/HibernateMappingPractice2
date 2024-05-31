
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

//lombok annnotation:
@Getter
@Setter
@NoArgsConstructor

//jakarta annotation:
@Entity
@Table
public class Doctors implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int doctorId;
    private String doctorName;


}
