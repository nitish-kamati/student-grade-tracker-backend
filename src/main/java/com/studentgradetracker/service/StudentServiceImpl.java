package com.studentgradetracker.service;

import com.studentgradetracker.dto.CreateStudentRequest;
import com.studentgradetracker.dto.StudentResponse;
import com.studentgradetracker.dto.StudentStatsResponse;
import com.studentgradetracker.exception.StudentNotFoundException;
import com.studentgradetracker.model.Student;
import com.studentgradetracker.repository.StudentRepository;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponse addStudent(CreateStudentRequest request) {
        Student student = new Student();
        student.setName(request.getName().trim());
        student.setMarks(request.getMarks());

        Student savedStudent = studentRepository.save(student);
        return mapToResponse(savedStudent);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER))
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public StudentStatsResponse getStudentStats() {
        List<Student> students = studentRepository.findAll();

        if (students.isEmpty()) {
            return new StudentStatsResponse(0, 0, 0, 0);
        }

        double average = students.stream()
                .mapToDouble(Student::getMarks)
                .average()
                .orElse(0);

        double highest = students.stream()
                .mapToDouble(Student::getMarks)
                .max()
                .orElse(0);

        double lowest = students.stream()
                .mapToDouble(Student::getMarks)
                .min()
                .orElse(0);

        return new StudentStatsResponse(
                students.size(),
                roundToTwoDecimals(average),
                roundToTwoDecimals(highest),
                roundToTwoDecimals(lowest)
        );
    }

    @Override
    public void deleteStudent(String id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        studentRepository.delete(student);
    }

    private StudentResponse mapToResponse(Student student) {
        return new StudentResponse(
                student.getId(),
                student.getName(),
                roundToTwoDecimals(student.getMarks()),
                calculateGrade(student.getMarks())
        );
    }

    private String calculateGrade(double marks) {
        if (marks >= 90) {
            return "A";
        }
        if (marks >= 75) {
            return "B";
        }
        if (marks >= 60) {
            return "C";
        }
        return "D";
    }

    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
