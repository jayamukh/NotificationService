package org.example.service;

import org.example.models.Company;
import org.example.models.Employee;
import org.example.models.Message;
import org.example.models.MessageType;

import java.util.HashMap;
import java.util.Map;

public class MessageService {

    private Map<Employee, Map<MessageType, StringBuilder>> batchMessages = new HashMap<>();

    public void sendMessage(Company company, Message message) {
        for (Employee emp : company.getEmployees()) {
            if (!company.getSettings().canReceive(message.getType(), emp.getRole())) continue;
            if (company.getSettings().shouldSendImmediately(message.getType())) {
                emp.getPrimaryMethod().sendMessage(message.getContent(), emp.getContactDetail());
            }
            else {
                batchMessages
                        .computeIfAbsent(emp, k -> new HashMap<>())
                        .compute(message.getType(), (k,v) -> {
                    if (v == null) return new StringBuilder(message.getContent());
                    v.append("\n").append(message.getContent());
                    return v;

                });
            }

        }

    }

    public Map<Employee, Map<MessageType, StringBuilder>> getBatchMessages() {
        return batchMessages;
    }

}
