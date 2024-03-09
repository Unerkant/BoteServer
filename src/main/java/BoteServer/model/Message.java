package BoteServer.model;

import org.springframework.stereotype.Service;

/**
 * Den 7.3.2024
 */

public class Message {

    private String name;
    private String text;

    public Message(){
        // ...
    }

    public Message(String name, String text){
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        return "Message{" + "name=" + name + ", text " + text + "}";
    };
}