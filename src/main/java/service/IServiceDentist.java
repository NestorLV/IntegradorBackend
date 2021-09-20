package service;

import model.DentistDto;

import java.util.List;

public interface IServiceDentist extends IServiceCRUD<DentistDto> {
    List<DentistDto> searchByNameDto(String name);
}
