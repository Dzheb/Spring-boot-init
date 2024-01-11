package com.dzheb.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainRESTController {
    @Autowired
    private StudentRepository studentRepository;

    // alternatively
    //    private final StudentRepository studentRepository;
    //
    // GET /student - получить всех студентов
    @GetMapping(value = "/students")
    public StudentRepository showAllStudents() {
        return studentRepository;
    }

    // GET /students/{id} - получить студента по ID
    @GetMapping(value = "/students/{id}")
    public Student getStudent(@PathVariable long id) throws Exception {
        Student student = studentRepository.getById(id);
        if (student == null) {
            throw new Exception("There is no" +
                    "student with id = " + id + " in Database");
        }
        return student;
    }

    // GET /group/{group}/student -
    // получить всех студентов группы
    // /student - лишний вроде?
    @GetMapping(value = "/group/{group}")
    public ArrayList<Student> getGroup(@PathVariable int group) {
        return studentRepository.getGroupById(group);
    }

    // POST /student - создать студента (принимает JSON)
    @PostMapping("/students")
    public Student getNewStudent(@RequestBody Student student) {
        studentRepository.saveStudent(student);
        return student;
    }

    // GET /student/search?name='studentName' -
    // получить список студентов, чье имя содержит
    // подстроку studentName (первое слово в поле имя)
    @GetMapping("/students/search")
    public List<Student> getStudentByName(@RequestParam String name) {
        System.out.println(name);
        return studentRepository.getByName(name);
    }

    // DELETE /student/{id} - удалить студента
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable long id) {
        Student student = studentRepository.getById(id);
        if (student == null) {
            return "There is no student with id = " + id + " in Database";
        }
        studentRepository.deleteStudent(id);
        return "Student with id = " + id + " was deleted";
    }

}

