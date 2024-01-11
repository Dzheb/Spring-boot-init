package com.dzheb.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. Создать spring-boot приложение с помощью https://start.spring.io/
 * 2. Создать Класс Student c полями: идентификатор, имя, имя группы
 * 3. Создать контроллер, обрабатывающий входящие запросы:
 * 3.1 GET /student/{id} - получить студента по ID
 * 3.2 GET /student - получить всех студентов
 * 3.3 GET /student/search?name='studentName' - получить список студентов, чье имя содержит подстроку studentName
 * 3.4 GET /group/{groupName}/student - получить всех студентов группы
 * 3.5 POST /student - создать студента (принимает JSON) (отладиться можно с помощью Postman)
 * 3.6 DELETE /student/{id} - удалить студента
 * 4. При старте приложения, в программе должно быть создано 5-10 студентов.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class, args);
        Student std1 = new Student(1L, "Иван Иванов", 3);
        Student std2 = new Student(2L, "Аннв Иванова", 2);
        Student std3 = new Student(3L, "Марина Немова", 3);
        Student std4 = new Student(4L, "Владимир Жуков", 4);
        Student std5 = new Student(5L, "Сергей Смирнов", 2);
        Student std6 = new Student(6L, "Роман Круг", 3);
        Student std7 = new Student(7L, "Ирина Ершова", 3);

        StudentRepository students = context.getBean(StudentRepository.class);
        ArrayList<Student> sts = new ArrayList<>(List
                .of(std1, std2, std3, std4, std5, std6));
        students.setStudents(sts);
    }

}
