package com.dhayalanit.getting_started_with_springboot_webflux.client;

import com.dhayalanit.getting_started_with_springboot_webflux.entity.Student;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Client {

    public void check() {

        WebClient webClient = WebClient.create("http://localhost:8081");

        String responses = webClient.get()
                .uri("/students")
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth("admin","123"))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(responses);

        Mono<Student> monoStudent = webClient.get()
                .uri("/students/{id}", "3")
                .headers(httpHeaders -> httpHeaders.setBasicAuth("admin","123"))
                .retrieve()
                .bodyToMono(Student.class);
        Student student = monoStudent.block();
        System.out.println("Mono Response " + student);

        Flux<Student> FluxStudent = webClient.get()
                .uri("/students/getAll")
                .headers(httpHeaders -> httpHeaders.setBasicAuth("admin","123"))
                .retrieve()
                .bodyToFlux(Student.class);
        FluxStudent.subscribe(System.out::println);

    }
}
