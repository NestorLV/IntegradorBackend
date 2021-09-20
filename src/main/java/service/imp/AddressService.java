package service.imp;
import model.AddressDto;
import persistence.entities.Address;
import persistence.repository.IAddressRepository;
import service.IServiceAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
public class AddressService  implements IServiceAddress{

    @Autowired
    IAddressRepository repositoryAddress;

    @Override
    public AddressDto save(AddressDto addressDto) {
        addressDto.setId(repositoryAddress.save(addressDto.toEntity()).getId());
        return addressDto;
    }

    @Override
    public List<AddressDto> findAll() {
        List<AddressDto> domicilios = new ArrayList<>();
        for(Address a: repositoryAddress.findAll()){
            domicilios.add(new AddressDto(a));
        }
        return domicilios;
    }

    @Override
    public AddressDto update(AddressDto addressDto) {
        repositoryAddress.save(addressDto.toEntity());
        return addressDto;
    }
}
