package com.codecool.neptunus;

import com.codecool.neptunus.model.Gender;
import com.codecool.neptunus.model.Role;
import com.codecool.neptunus.model.Teacher;
import com.codecool.neptunus.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = NeptunusApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:IT-application.properties")
class NeptunusApplicationIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TeacherRepository teacherRepository;

    private Teacher teacher;

    @Test
    @WithMockUser(username="admin",roles={"TEACHER"})
    void getAllTeacher() throws Exception {
        teacherRepository.deleteAll();
        Teacher teacher1 = new Teacher();
        teacher1.setId(1);
        teacher1.setPassword("secret");
        teacher1.setGender(Gender.MALE);
        teacher1.setName("Adam Smith");
        teacher1.setDateOfBirth(LocalDate.of(2018, 11, 1));
        teacher1.setRoles(Set.of(Role.ROLE_TEACHER));
        teacherRepository.save(teacher1);

        mockMvc.perform(get("/api/teachers/all"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Adam Smith"));


    }

}
