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
public class Address implements Serializable{
    @Id
    @GeneratedValue(generator = "seqAddress", strategy =  GenerationType.SEQUENCE)
    @SequenceGenerator(name ="seqAddress", sequenceName = "DB_SEQ_ADDRESS", allocationSize = 1)
    private String city;
    private String neighborhood;
    private String number;
    private String street;
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private Set<Patient> patients;

    public Address(String street, String number, String neighborhood, String city) {
        this.city = city;
        this.neighborhood = neighborhood;
        this.number = number;
        this.street = street;
    }

    public Address() {
    }
}
