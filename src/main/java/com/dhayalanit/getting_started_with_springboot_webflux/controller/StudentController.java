package com.dhayalanit.getting_started_with_springboot_webflux.controller;

import com.dhayalanit.getting_started_with_springboot_webflux.entity.Student;
import com.dhayalanit.getting_started_with_springboot_webflux.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private final StudentRepo studentRepo;

    public StudentController() {
        studentRepo = new StudentRepo();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Mono<String> index() {
        return Mono.just("OK");
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Mono<Student> getStudentId(@PathVariable String id) {
        return studentRepo.findStudentId(id);
    }

    @GetMapping(path = "/getAll")
    public Flux<Student> getStudents() {
        return studentRepo.findAllStudents();
    }

    @PostMapping("/update")
    public Mono<Student> updateStudent(@RequestBody Student student) {
        return studentRepo.updateStudent(student);
    }
}
