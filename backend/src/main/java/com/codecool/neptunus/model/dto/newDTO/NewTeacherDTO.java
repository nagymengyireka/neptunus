package com.codecool.neptunus.model.dto.newDTO;

import com.codecool.neptunus.model.Gender;

import java.time.LocalDate;

public record NewTeacherDTO(String username, String password, String name, LocalDate dateOfBirth, Gender gender) {
}
