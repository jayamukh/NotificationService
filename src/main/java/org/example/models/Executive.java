package org.example.models;

import org.example.Communication.CommunicationMethod;

import java.util.List;

public class Executive extends Employee {
    public Executive(String name, String email, String phone, List<CommunicationMethod> methods, CommunicationMethod primaryMethod) {
        super(name, email, phone, methods, primaryMethod);
    }

    public String getRole() {
        return "Executive";
    }
}