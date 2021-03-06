package com.kafka.producerexample.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


public class User {
    private String name;
    private String department;

    public User(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
