package com.mahmoud.dahdouh.project;

class Student {

    private String name;
    private String school;
    private int image;

    public Student() {

    }

    public Student(String name, String school, int image) {
        this.name = name;
        this.school = school;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
