package persistence.entities;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Turn implements Serializable {
    @Id
    @GeneratedValue(generator = "seqTurn" , strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seqTurn", sequenceName = "DB_SEQ_TURN", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDate admissionDate;
}
