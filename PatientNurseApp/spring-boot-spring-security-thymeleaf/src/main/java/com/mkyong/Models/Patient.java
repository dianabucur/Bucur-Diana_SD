package com.mkyong.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patient_id;

    @Column(name = "name")
    private String name;

    @Column(name = "cardnr")
    private String cardnr;

    @Column(name = "age")
    private Integer age;

    @Column(name = "disease")
    private String disease;

    @Column(name = "roomno")
    private Integer roomno;

    @ManyToMany(fetch=FetchType.EAGER, cascade =CascadeType.ALL)
    @JoinTable(
            name = "cure",
            joinColumns = { @JoinColumn(name = "patient_id") },
            inverseJoinColumns = { @JoinColumn(name = "med_id") }
    )
    List<Medicine> medication = new ArrayList<>();

    public Patient(String name, String cardnr, Integer age, String disease, Integer roomno) {
        this.name = name;
        this.cardnr = cardnr;
        this.age = age;
        this.disease = disease;
        this.roomno = roomno;
       // this.medication = medication;
    }

    public Patient (){ }

    public String getCardnr() {
        return cardnr;
    }

    public void setCardnr(String cardnr) {
        this.cardnr = cardnr;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Integer getRoomno() {
        return roomno;
    }

    public void setRoomno(Integer roomno) {
        this.roomno = roomno;
    }

    public List<Medicine> getMedication() {
        return medication;
    }

    public void setMedication(List<Medicine> medication) {
        this.medication = medication;
    }

}
