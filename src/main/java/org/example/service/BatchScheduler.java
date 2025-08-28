package org.example.service;

import org.example.models.Employee;
import org.example.models.MessageType;

import java.util.*;

public class BatchScheduler {

    private MessageService messageService;

    public BatchScheduler(MessageService messageService) {
        this.messageService = messageService;
    }

    public void runNightlyBatch() {
        for (Map.Entry<Employee, Map<MessageType, StringBuilder>> empEntry : messageService.getBatchMessages().entrySet()) {
            Employee emp = empEntry.getKey();
            for (Map.Entry<MessageType, StringBuilder> msgEntry : empEntry.getValue().entrySet()) {
                emp.getPrimaryMethod().sendMessage(
                        "[Batched " + msgEntry.getKey() + "]\n" + msgEntry.getValue().toString(),
                        emp.getContactDetail()
                );
            }
        }

        messageService.getBatchMessages().clear();
    }
}
