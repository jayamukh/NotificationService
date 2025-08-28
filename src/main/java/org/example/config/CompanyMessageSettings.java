package org.example.config;

import org.example.models.MessageType;

import java.util.*;
public class CompanyMessageSettings {
    private Map<MessageType, Set<String>> allowedRoles = new HashMap<>();
    private Map<MessageType, Boolean> sendImmediately = new HashMap<>();

    public void setAllowedRoles(MessageType type, Set<String> roles) {
        allowedRoles.put(type, roles);
    }

    public void setSendImmediately(MessageType type, boolean immediate )
    {
        sendImmediately.put(type, immediate);
    }

    public boolean shouldSendImmediately(MessageType type) {
        return sendImmediately.getOrDefault(type, true);
    }

    public boolean canReceive(MessageType type, String role) {
        return allowedRoles.getOrDefault(type, new HashSet<>()).contains(role);
    }
}
