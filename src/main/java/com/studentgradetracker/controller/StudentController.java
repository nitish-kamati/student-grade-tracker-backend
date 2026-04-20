package com.studentgradetracker.controller;

import com.studentgradetracker.dto.CreateStudentRequest;
import com.studentgradetracker.dto.StudentResponse;
import com.studentgradetracker.dto.StudentStatsResponse;
import com.studentgradetracker.service.StudentService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponse> addStudent(@Valid @RequestBody CreateStudentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(request));
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/stats")
    public StudentStatsResponse getStudentStats() {
        return studentService.getStudentStats();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }
}
