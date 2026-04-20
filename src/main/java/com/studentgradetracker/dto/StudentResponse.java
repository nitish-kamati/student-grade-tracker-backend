package com.studentgradetracker.dto;

public class StudentResponse {

    private String id;
    private String name;
    private double marks;
    private String grade;

    public StudentResponse() {
    }

    public StudentResponse(String id, String name, double marks, String grade) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
