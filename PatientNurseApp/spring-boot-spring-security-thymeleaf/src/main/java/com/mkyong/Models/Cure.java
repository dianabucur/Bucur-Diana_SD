package com.mkyong.Models;

import javax.persistence.*;

public class Cure {

    private Integer patient_id;
    private Integer med_id;

    public Cure(){}

    public Cure(Integer patient_id, Integer med_id) {
        this.patient_id = patient_id;
        this.med_id = med_id;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public Integer getMed_id() {
        return med_id;
    }

    public void setMed_id(Integer med_id) {
        this.med_id = med_id;
    }
}
