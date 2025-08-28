package org.example.models;

import org.example.Communication.CommunicationMethod;

import java.util.List;

public class Developer extends Employee {
    public Developer(String name, String email, String phone, List<CommunicationMethod> methods, CommunicationMethod primaryMethod) {
        super(name, email, phone, methods, primaryMethod);
    }

    @Override
    public String getRole() {
        return "DEV";
    }


}
