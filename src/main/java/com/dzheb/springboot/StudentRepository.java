package com.dzheb.springboot;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Component
public class StudentRepository {
    private ArrayList<Student> students;

    public StudentRepository(ArrayList<Student> students) {
    }

    public Student getById(long id) {
        return students.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public void saveStudent(Student student) {
        this.students.add(student);
    }

    public List<Student> getByName(String name) {
        return students.stream()
                .filter(it -> Objects.equals(Arrays
                        .asList(it.getName().split(" ")).get(0), name))
                .collect(Collectors.toList());
    }

    public void deleteStudent(long id) {
        this.students = (ArrayList<Student>) this.students.stream()
                .filter(it -> !Objects.equals(it.getId(), id))
                .collect(Collectors.toList());
    }

    public ArrayList<Student> getGroupById(int group) {
        return (ArrayList<Student>) this.students.stream()
                .filter(it -> Objects.equals(it.getGroup(), group))
                .collect(Collectors.toList());

    }
}
