package com.dhayalanit.getting_started_with_springboot_webflux.repo;

import com.dhayalanit.getting_started_with_springboot_webflux.entity.Student;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@Repository
public class StudentRepo {

    public static final Student DHAYLAN = new Student(1,"Dhayalan","dhaya");
    public static final Student SHRAVAN = new Student(2,"Shravan","shravn");
    public static final Student RAKSHANA = new Student(3, "Rakshana","Raks");
    public static final Student THILAGAVATHI = new Student(4, "Thilagavathi","Thilaga");

    static HashMap<String, Student> studentList;
    static {
        studentList = new HashMap<>();
        studentList.put("1",DHAYLAN);
        studentList.put("2",SHRAVAN);
        studentList.put("3",RAKSHANA);
        studentList.put("4",THILAGAVATHI);
    }

    public Mono<Student> findStudentId(String id) {
        return Mono.just(studentList.get(id));
    }

    public Flux<Student> findAllStudents() {
        return Flux.fromIterable(studentList.values());
    }

    public Mono<Student> updateStudent(Student student) {
        Student student1 = studentList.get(student.getId());
        if(student1 != null) {
            student1.setName(student.getName());
        }
        return Mono.just(student1);
    }

}
