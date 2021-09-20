package model;
import lombok.Getter;
import lombok.Setter;
import persistence.entities.Dentist;

@Setter
@Getter
public class DentistDto {
    private Long id;
    private String name;
    private String lastName;
    private String registration;

    public Dentist toEntity (){
        Dentist entity = new Dentist();
        entity.setId(id);
        entity.setName(name);
        entity.setLastName(lastName);
        entity.setRegistration(registration);
        return  entity;
    }

    public DentistDto(String name, String lastName, String registration) {
        this.name = name;
        this.lastName = lastName;
        this.registration = registration;
    }

    public DentistDto (Dentist d){
        id = d.getId();
        name = d.getName();
        lastName = d.getLastName();
        registration = d.getRegistration();
    }

    public DentistDto(Long id, String name, String lastName, String registration) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.registration = registration;
    }

    public DentistDto(Long id){this.id = id;}

    public DentistDto() { }
}