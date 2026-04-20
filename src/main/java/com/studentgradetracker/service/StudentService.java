package com.studentgradetracker.service;

import com.studentgradetracker.dto.CreateStudentRequest;
import com.studentgradetracker.dto.StudentResponse;
import com.studentgradetracker.dto.StudentStatsResponse;
import java.util.List;

public interface StudentService {

    StudentResponse addStudent(CreateStudentRequest request);

    List<StudentResponse> getAllStudents();

    StudentStatsResponse getStudentStats();

    void deleteStudent(String id);
}
