package org.example.models;
import org.example.Communication.Email;
import org.example.Communication.CommunicationMethod;

import java.util.List;

public abstract class Employee {
    protected String name;
    protected String email;
    protected String phone;
    protected List<CommunicationMethod> methods;
    protected CommunicationMethod primaryMethod;

    public Employee(String name, String email, String phone, List<CommunicationMethod> methods, CommunicationMethod primaryMethod) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.methods = methods;
        this.primaryMethod = primaryMethod;
    }

    public CommunicationMethod getPrimaryMethod() {
        return primaryMethod;
    }

    public String getContactDetail() {
        return primaryMethod instanceof org.example.Communication.Email ? email : phone;
    }

    public abstract String getRole();
}
