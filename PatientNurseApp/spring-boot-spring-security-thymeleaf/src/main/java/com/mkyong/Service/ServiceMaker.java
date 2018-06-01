package com.mkyong.Service;

import com.mkyong.Models.Call;
import com.mkyong.Models.Medicine;
import com.mkyong.Models.Patient;
import com.mkyong.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMaker {

    @Autowired
    private CallService callService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private UserService userService;


    public void insertCall (Call call){
        callService.insert(call);
    }

    public void insertPatient (Patient patient){
        patientService.insert(patient);
    }

    public void insertMedicine (Medicine medicine){
        medicineService.insert(medicine);
    }

    public void insertUser (User user){
        userService.insert(user);
    }

    public void removeCall (Integer id){
        callService.remove(id);
    }

    public void removePatient (Integer id){
        patientService.remove(id);
    }

    public void removeMedicine (Integer id){
        medicineService.remove(id);
    }

    public void removeUser (Integer id){
        userService.remove(id);
    }

    public Call findByIdCall (Integer id){
        return (Call) callService.findById(id);
    }

    public Patient findByIdPatient (Integer id){
        return (Patient) patientService.findById(id);
    }

    public User findByUsernameUser (String username){
        return (User) userService.findByUsername(username);
    }

    public Medicine findByIdMedicine (Integer id){
        return (Medicine) medicineService.findById(id);
    }

    public User findByIdUser (Integer id){
        return (User) userService.findById(id);
    }

    public List<Call> findAllCall (){
        return (List<Call>) callService.findAll();
    }

    public List<Patient> findAllPatient (){
        return (List<Patient>) patientService.findAll();
    }

    public List<User> findAllUser (){
        return (List<User>) userService.findAll();
    }

    public List<Medicine> findAllMedicine(){
        return (List<Medicine>) medicineService.findAll();
    }

    public Patient findByNamePatient(String name){
        return (Patient) patientService.findByName(name);
    }

}
