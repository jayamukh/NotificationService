package org.example.Communication;

import org.example.models.Employee;

public class SMS implements CommunicationMethod{
    @Override
    public void sendMessage(String msg, String rcp) {
        System.out.println("send message to " +rcp+ " " + msg);
    }

}
