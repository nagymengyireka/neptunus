package com.codecool.neptunus.model.dto;

import com.codecool.neptunus.model.Gender;

import java.time.LocalDate;

public record StudentDTO(Long id, String studentId, String password, String lastName, String firstName, LocalDate dateOfBirth, Gender gender) {
}
