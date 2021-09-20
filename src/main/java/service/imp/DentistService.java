package service.imp;

import model.DentistDto;
import persistence.entities.Dentist;
import persistence.repository.IDentistRepository;
import service.IServiceDentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DentistService  implements IServiceDentist{

    @Autowired
    IDentistRepository repository;

    @Override
    public DentistDto save(DentistDto dentistDto) {
        dentistDto.setId(repository.save(dentistDto.toEntity()).getId());
        return dentistDto;
    }

    @Override
    public List<DentistDto> findAll() {
        List <DentistDto> dentistDtos = new ArrayList<>();
        for (Dentist o: repository.findAll()){
           dentistDtos.add(new DentistDto(o));
        }
        return dentistDtos;
    }

    @Override
    public DentistDto update(DentistDto dentistDto) {
        repository.save(dentistDto.toEntity());
        return dentistDto;
    }

    @Override
    public List<DentistDto> searchByNameDto(String name) {
        List<DentistDto> dentistDtos = repository.searchDentistByName(name).stream().map(o -> new DentistDto(o)).collect(Collectors.toList());
        return dentistDtos;
    }
}
