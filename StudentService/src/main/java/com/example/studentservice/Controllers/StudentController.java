package com.example.studentservice.Controllers;



import com.example.studentservice.Client.Branchclient;
import com.example.studentservice.Models.Branch;
import com.example.studentservice.Services.StudentService;
import com.example.studentservice.entities.Student;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor

@RestController
@CrossOrigin("*")
public class StudentController {
private  final Branchclient branchclient;
    private final StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity savestudent(@RequestBody Student student){
        studentService.savstudent(student);
        return new ResponseEntity(HttpStatus.CREATED);

    }
    @GetMapping("students")
    public ResponseEntity<List<Student>> getstudents(){
        List E=studentService.getstudents();
        return  new ResponseEntity<>(E,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity deletestudent(@PathVariable Long id){
        studentService.Deletestudent(id);
        return new ResponseEntity((HttpStatus.ACCEPTED));
    }


    @GetMapping("students/{id}")

    public ResponseEntity<Student> getstudent(@PathVariable Long id) {
        Student student=studentService.getstudent(id);
        Branch branch=branchclient.findBranchById(student.getIdBranch());
    student.setBranch(branch);
    return  new ResponseEntity<Student>(student,HttpStatus.OK);
    }

}
