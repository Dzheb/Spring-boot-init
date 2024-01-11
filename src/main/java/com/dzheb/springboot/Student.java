package com.dzheb.springboot;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
public class Student {
    long id;
    String name;
    int group;

    public Student(long id, String name, int group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group=" + group +
                '}';
    }
}
