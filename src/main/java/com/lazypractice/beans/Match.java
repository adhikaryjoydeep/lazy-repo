package com.lazypractice.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;



@Entity
@Table(name = "MATCHES")
public class Match implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Match() {
        System.out.printf("Match instance is created.");
    }



}
