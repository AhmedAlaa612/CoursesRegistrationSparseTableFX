package com.example.regstrationsparsetablefx;

public class Ptr {
    private String name;
    private String id;
    private Node next;

    public Ptr(String name, String id) {
        this.name = name;
        this.id = id;
        next = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Node getNext() {
        return next;
    }
}
