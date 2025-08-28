package org.example.Communication;

import org.example.models.Employee;

public interface CommunicationMethod {

    void sendMessage(String msg, String rcp);
    //String getContactDetail(Employee employee);
}
