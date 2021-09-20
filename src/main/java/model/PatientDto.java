package model;

import persistence.entities.Patient;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PatientDto {

    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private LocalDate admissionDate;
    private AddressDto address;

    public Patient toEntity(){
        Patient entity = new Patient();
        entity.setId(id);
        entity.setLastName(lastName);
        entity.setDni(dni);
        entity.setName(name);
        entity.setAdmissionDate(admissionDate);
        entity.setAddress(address.toEntity());
        return entity;
    }

    public PatientDto(Patient p){
        id = p.getId();
        name = p.getName();
        lastName = p.getLastName();
        dni = p.getDni();
        admissionDate = p.getAdmissionDate();
        address = new AddressDto(p.getAddress());
    }

    public PatientDto() {}
}
