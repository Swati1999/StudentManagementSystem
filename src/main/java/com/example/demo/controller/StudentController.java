package com.example.demo.controller;

import com.example.demo.dto.AddRequestDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping("/student")
    public ResponseEntity<List<StudentDto>> getStudent(){

        return ResponseEntity.ok(studentService.getAllStudents());
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){

        return ResponseEntity.ok(studentService.getStudentByID(id));
    }

    @PostMapping("/student")
    public ResponseEntity<StudentDto> createStudent(@RequestBody AddRequestDto addRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(addRequestDto));
    }
}
