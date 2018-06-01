package com.mkyong.Models;

import javax.persistence.*;

@Entity
@Table(name = "callnurse")
public class Call {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "call_id")
    private Integer id;

    @Column(name = "reason")
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id")
    private Patient patient;

    public Call(){}

    public Call(String reason, Patient patient) {
        this.reason = reason;
        this.patient = patient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
