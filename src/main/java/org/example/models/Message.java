package org.example.models;

public class Message {
    private final MessageType type;
    private final String content;

    public Message(MessageType type, String msg)
    {
        this.content = msg;
        this.type = type;
    }

    public MessageType getType()
    {
        return type;
    }

    public String getContent()
    {
        return content;
    }
}
