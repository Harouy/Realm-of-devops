package com.example.demo.Controller;

import com.example.demo.Services.StudentService;
import com.example.demo.entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StudentController {
    private final StudentService studentService;
    @PostMapping
    public ResponseEntity savestudent(@RequestBody Student student){
        studentService.savstudent(student);
        return new ResponseEntity(HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<Student>> getstudents(){
        List E=studentService.getstudents();
        return  new ResponseEntity<>(E,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletestudent(@PathVariable Long id){
        studentService.Deletestudent(id);
        return new ResponseEntity((HttpStatus.ACCEPTED));
    }





}
