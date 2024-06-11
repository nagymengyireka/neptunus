package com.codecool.neptunus.model.dto.newDTO;

import com.codecool.neptunus.model.Gender;

import java.time.LocalDate;

public record NewStudentDTO(String password, String lastName, String firstName, LocalDate dateOfBirth, Gender gender) {
}
