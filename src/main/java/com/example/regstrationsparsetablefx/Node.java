package com.example.regstrationsparsetablefx;

public class Node {
    private String name;
    private String course_name;
    private String id;
    private String course_id;
    private Node next_student;
    private Node next_course;

    public Node(String name, String id, String course_name, String course_id) {
        this.name = name;
        this.id = id;
        this.course_id = course_id;
        this.course_name = course_name;
        next_course = null;
        next_student = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Node getNext_student() {
        return next_student;
    }

    public void setNext_student(Node next_student) {
        this.next_student = next_student;
    }

    public Node getNext_course() {
        return next_course;
    }

    public void setNext_course(Node next_course) {
        this.next_course = next_course;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_name(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
}
