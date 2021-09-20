package model;

import lombok.Getter;
import lombok.Setter;
import persistence.entities.Address;

@Getter
@Setter
public class AddressDto {
    private Long id;
    private String street;
    private String number;
    private String neighborhood;
    private String city;

    public Address toEntity(){
        Address entity = new Address();
        entity.setId(id);
        entity.setStreet(street);
        entity.setNeighborhood(neighborhood);
        entity.setCity(city);
        entity.setNumber(number);
        return entity;

    }
    public AddressDto (Address a){
        id = a.getId();
        street = a.getStreet();
        number = a.getNumber();
        neighborhood = a.getNeighborhood();
        city = a.getCity();
    }

    public AddressDto(Long id, String street, String number, String neighborhood, String city) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    public AddressDto(String street, String number, String neighborhood, String city) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    public AddressDto(Long id){this.id = id;}
    public AddressDto() { }
}
