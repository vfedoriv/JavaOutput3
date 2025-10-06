package com.example.entity;

public class Student {
    private Long id;
    private String name;
    private String address;
    private Long courseId;

    public Student(Long id, String name, String address, Long courseId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.courseId = courseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}