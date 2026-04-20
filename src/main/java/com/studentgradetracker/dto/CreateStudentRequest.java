package com.studentgradetracker.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateStudentRequest {

    @NotBlank(message = "Student name is required.")
    private String name;

    @NotNull(message = "Marks are required.")
    @DecimalMin(value = "0.0", message = "Marks must be at least 0.")
    @DecimalMax(value = "100.0", message = "Marks must not exceed 100.")
    private Double marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }
}
