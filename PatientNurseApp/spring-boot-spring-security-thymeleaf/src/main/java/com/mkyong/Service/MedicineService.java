package com.mkyong.Service;

import com.mkyong.Models.Medicine;
import com.mkyong.Models.Patient;
import com.mkyong.Repository.MedicineRepository;
import com.mkyong.Repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService implements ServiceInterface<Medicine> {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public void insert(Medicine obj) {

    }

    public Medicine findById(Integer id){

        return medicineRepository.findOne(id);
    }

    public List<Medicine> findAll() {

        return medicineRepository.findAll();
    }

    @Override
    public void remove(Integer id) {

    }
}
