package com.example.demo.service.impl;

import com.example.demo.dto.AddRequestDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(student-> new StudentDto(student.getId(), student.getName(), student.getEmail()))
                .toList();
    }
    @Override
    public StudentDto getStudentByID(Long id){
        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not found with id:"+ id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createStudent(AddRequestDto addRequestDto) {
        Student newStudent = modelMapper.map(addRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }
}
