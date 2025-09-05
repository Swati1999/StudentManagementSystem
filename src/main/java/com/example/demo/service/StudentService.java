package com.example.demo.service;

import com.example.demo.dto.AddRequestDto;
import com.example.demo.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();
    StudentDto getStudentByID(Long id);
    StudentDto createStudent(AddRequestDto addRequestDto);
    Void deleteStudent(Long id);

    StudentDto updateStudent(Long id, AddRequestDto addRequestDto);
}
