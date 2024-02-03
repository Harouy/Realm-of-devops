package com.example.demo.Services;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public void savstudent(Student student){
        studentRepository.save(student);
    }
    public List<Student> getstudents(){
        return studentRepository.findAll();
    }
    public void Deletestudent(Long id){
        studentRepository.delete(studentRepository.findById(id).get());
    }


}


