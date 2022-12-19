package com.dhayalanit.getting_started_with_springboot_webflux.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int id;
    private String name;
    private String surname;

}
