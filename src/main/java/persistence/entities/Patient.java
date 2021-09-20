package persistence.entities;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@ToString
@Setter
public class Patient implements Serializable {
    @Id
    @GeneratedValue(generator = "seqPatient", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seqPatient", sequenceName = "DB_SEQ_PATIENT", allocationSize = 1)
    private LocalDate admissionDate;
    private String dni;
    private String lastName;
    private String name;
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "patient")
    private Set<Turn> turns;

    public Patient(String name, String lastName, String dni, LocalDate admissionDate, Address address) {
        this.address = address;
        this.admissionDate = admissionDate;
        this.lastName = lastName;
        this.name = name;
        this.dni = dni;
    }

    public Patient() {
    }
}
