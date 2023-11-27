package com.example.regstrationsparsetablefx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class SparseTable {
    // singleton
    private static SparseTable instance;
    private SparseTable() {}
    public static SparseTable getInstance(){
        if (instance == null)
            instance = new SparseTable();
        return instance;
    }
    // tables
    ObservableList<Ptr> StudentsList = FXCollections.observableArrayList();
    ObservableList<Ptr> CoursesList = FXCollections.observableArrayList();
    Map<String, Ptr> students = new HashMap<>();
    Map<String, Ptr> courses = new HashMap<>();
    public void addStudent(String name, String id) throws Exception{
        if (students.get(id) != null) {throw new Exception("Already exist!");}
        else{
            Ptr student = new Ptr(name, id);
            students.put(id, student);
            StudentsList.add(student);
        }
    }
    public void addCourse(String name, String id) throws Exception{
        if (courses.get(id) != null) throw new Exception("Already exist!");
        else{
            Ptr course = new Ptr(name, id);
            courses.put(id, course);
            CoursesList.add(course);
        }
    }
    public void enroll(String id, String course_id) throws Exception{
        // get the head of the course and student and check if they exist
        Ptr studentInfo = students.get(id);
        Ptr courseInfo = courses.get(course_id);
        if (studentInfo == null) throw new Exception("No student with this id");
        else if (courseInfo == null) throw new Exception("course not found");
        else {
            // if they exist check for their log
            Node student = studentInfo.getNext();
            Node course = courseInfo.getNext();
            // create node
            Node newStudent = new Node(studentInfo.getName(), id, courseInfo.getName(),course_id);
            // if the log is empty add the student to the head
            if (student == null) studentInfo.setNext(newStudent);
            else {
                // else loop through the log and add the student to the tail
                while (student.getNext_student() != null) {
                    if(student.getCourse_id().equals(course_id)){
                        throw new Exception("Student already in this course");
                    }
                    student = student.getNext_student();
                }
                if(student.getCourse_id().equals(course_id)){
                    throw new Exception("Student already in this course");
                }
                student.setNext_student(newStudent);
            }
            if (course == null) courseInfo.setNext(newStudent);
            else {
                while (course.getNext_course() != null) {
                    course = course.getNext_course();
                }
                course.setNext_course(newStudent);
            }
        }
    }
    public ObservableList<Node> get_students_in_course(String id) throws Exception{
        ObservableList<Node> stdList = FXCollections.observableArrayList();
        Ptr courseInfo = courses.get(id);
        if (courseInfo == null) throw new Exception("No such course");
        else {
            Node course = courseInfo.getNext();
            if (course == null) throw new Exception("no students in course");
            else {
                while (course != null) {
                    stdList.add(course);
                    course = course.getNext_course();
                }
            }
        }
        return stdList;
    }
    public void withdraw(String id, String course_id) throws Exception{
        Ptr studentInfo = students.get(id);
        Ptr courseInfo = courses.get(course_id);
        if (studentInfo == null) throw new Exception("Student doesn't exist");
        else if (courseInfo == null) throw new Exception("course not found");
        else{
            Node student = studentInfo.getNext();
            Node course = courseInfo.getNext();
            if (student == null) throw new Exception("student is not enrolled in courses");
            else if (course == null) throw new Exception("No students in course");
            else{
                boolean done = false;
                if (student.getCourse_id().equals(course_id)){
                    studentInfo.setNext(student.getNext_student());
                    done = true;
                }
                else{
                    while(student.getNext_student() != null){
                        if (student.getNext_student().getCourse_id().equals(course_id)){
                            student.setNext_student(student.getNext_student().getNext_student());
                            done = true;
                            break;
                        }
                        student = student.getNext_student();
                    }
                }
                if (!done) throw new Exception("student is not in course");
                else{
                    if (course.getId().equals(id)){
                        courseInfo.setNext(course.getNext_course());
                    }
                    else{
                        while(course.getNext_course() != null){
                            if (course.getNext_course().getId().equals(id)){
                                course.setNext_course(course.getNext_course().getNext_course());
                                break;
                            }
                            course = course.getNext_course();
                        }
                    }
                }
            }
        }
    }
    public ObservableList<Node> get_student_courses(String id) throws Exception{
        ObservableList<Node> Clist = FXCollections.observableArrayList();
        Ptr studentInfo = students.get(id);
        if (studentInfo == null) throw new Exception("student doesn't exist");
        else {
            Node student = studentInfo.getNext();
            if (student == null) throw new Exception("no courses");
            else {
                while (student != null) {
                    Clist.add(student);
                    student = student.getNext_student();
                }
            }
        }
        return Clist;
    }
    public void deleteStudent(String id) throws Exception{
        try{
            ObservableList<Node> Clist = get_student_courses(id);
            for (Node course : Clist){
                getInstance().withdraw(id, course.getCourse_id());
            }
            StudentsList.remove(students.get(id));
            students.remove(id);
        }
        catch (Exception ex){
            if (ex.getMessage().equals("no courses")){
                StudentsList.remove(students.get(id));
                students.remove(id);
            }
            else{
                throw new Exception(ex.getMessage());
            }
        }
    }
    public void deleteCourse(String id) throws Exception{
        try{
            ObservableList<Node> Clist = get_students_in_course(id);
            for (Node student : Clist){
                getInstance().withdraw(student.getId(), id);
            }
            CoursesList.remove(courses.get(id));
            courses.remove(id);
        }
        catch (Exception ex){
            if (ex.getMessage().equals("no students in course")){
                CoursesList.remove(courses.get(id));
                courses.remove(id);
            }
            else{
                throw new Exception(ex.getMessage());
            }
        }
    }
}
