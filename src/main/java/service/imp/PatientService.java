package service.imp;
import model.PatientDto;
import persistence.entities.Patient;
import persistence.repository.IAddressRepository;
import persistence.repository.IPatientRepository;
import service.IServicePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService implements IServicePatient{

    @Autowired
    IPatientRepository repositoryPatient;

    @Autowired
    IAddressRepository repositoryAddress;

    @Override
    public PatientDto save(PatientDto patientDto) {
        patientDto.setAdmissionDate(LocalDate.now());
        patientDto.setId(repositoryPatient.save(patientDto.toEntity()).getId());
        return patientDto;
    }

    @Override
    public List<PatientDto> findAll() {
        List<PatientDto> patients = new ArrayList<>();

        for(Patient p: repositoryPatient.findAll()){
            patients.add(new PatientDto(p));
        }
        return patients;
    }

    @Override
    public PatientDto update(PatientDto patientDto) {
        patientDto.setAdmissionDate(repositoryPatient.getById(patientDto.getId()).getAdmissionDate());
        repositoryPatient.save(patientDto.toEntity());
        return patientDto;
    }
}
