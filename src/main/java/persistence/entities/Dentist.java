package persistence.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Dentist implements Serializable {

    @Id
    @GeneratedValue(generator = "seqDentist", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="seqDentist", sequenceName="DB_SEQ_DENTIST", allocationSize=1)
    private String registration;
    private String lastName;
    private String name;
    private Long id;

    @OneToMany(mappedBy = "dentist")
    private Set<Turn> turns;

    public Dentist(String name, String lastName, String registration) {
        this.registration = registration;
        this.lastName = lastName;
        this.name = name;
    }

    public Dentist() {
    }
}
