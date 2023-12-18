package com.lazypractice.beans;

import java.time.LocalDate;

public class JobResult {
    private Long id;
    private String city;
    private LocalDate date;


    public JobResult(Long id, String city, LocalDate date) {
        this.id = id;
        this.city = city;
        this.date = date;
    }

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

    @Override
    public String toString() {
        return "JobResult{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", date=" + date +
                '}';
    }
}
