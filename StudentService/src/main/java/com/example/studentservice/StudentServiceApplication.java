package com.example.studentservice;

import com.example.studentservice.entities.Student;
import com.example.studentservice.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class StudentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){

        return args -> {

            Student student1= Student.builder().firstname("oussama")
                    .lastname("harouy")
                    .idBranch(Long.valueOf(1))
                    .email("Student1@com")

            .build();

            Student student2= Student.builder().firstname("Philipe")
                    .lastname("Cole")
                    .idBranch(Long.valueOf(2))
                    .email("Student2@com")

                    .build();
        studentRepository.save(student1);
        studentRepository.save(student2);
        };

        }
}
