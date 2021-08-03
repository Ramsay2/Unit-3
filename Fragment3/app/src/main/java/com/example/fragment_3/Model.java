package com.example.fragment_3;

import java.io.Serializable;

public class Model implements Serializable {
    private String name, grade, per;
    private int age;

    public Model(String name, String grade, String per, int age) {
        this.name = name;
        this.grade = grade;
        this.per = per;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String getPer() {
        return per;
    }

    public int getAge() {
        return age;
    }
}
