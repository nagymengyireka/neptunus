package com.codecool.neptunus.model.dto;

import com.codecool.neptunus.model.Gender;

import java.time.LocalDate;

public record TeacherDTO (Long id, String password, String name, LocalDate dateOfBirth, Gender gender){
}
