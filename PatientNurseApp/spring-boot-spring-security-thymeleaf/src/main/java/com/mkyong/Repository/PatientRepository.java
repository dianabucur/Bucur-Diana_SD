package com.mkyong.Repository;

import com.mkyong.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    public List<Patient> findAll();
    void delete(int id);
    Patient findOne(int id);
    Patient findByName(String name);
}
