package com.mkyong.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "med_id")
    private Integer id;

    @Column(name = "med_name")
    private String name;

    @ManyToMany(mappedBy = "medication")
    private List<Patient> patients = new ArrayList<>();

    public Medicine() {}

    public Medicine(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return   name;
    }
}
