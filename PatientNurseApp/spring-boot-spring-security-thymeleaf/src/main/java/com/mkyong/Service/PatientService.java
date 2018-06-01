package com.mkyong.Service;

import com.mkyong.Models.Patient;
import com.mkyong.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements ServiceInterface<Patient> {

    @Autowired
    private PatientRepository patientRepository;

    public void insert(Patient p) {
        patientRepository.save(p);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public void remove(Integer id ){
        patientRepository.delete(id);
    }

    public Patient findById(Integer id){
        return patientRepository.findOne(id);
    }

    public Patient findByName(String name){
        return patientRepository.findByName(name);
    }
}
