package com.studentgradetracker.dto;

public class StudentStatsResponse {

    private long totalStudents;
    private double averageMarks;
    private double highestMarks;
    private double lowestMarks;

    public StudentStatsResponse() {
    }

    public StudentStatsResponse(long totalStudents, double averageMarks, double highestMarks, double lowestMarks) {
        this.totalStudents = totalStudents;
        this.averageMarks = averageMarks;
        this.highestMarks = highestMarks;
        this.lowestMarks = lowestMarks;
    }

    public long getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(long totalStudents) {
        this.totalStudents = totalStudents;
    }

    public double getAverageMarks() {
        return averageMarks;
    }

    public void setAverageMarks(double averageMarks) {
        this.averageMarks = averageMarks;
    }

    public double getHighestMarks() {
        return highestMarks;
    }

    public void setHighestMarks(double highestMarks) {
        this.highestMarks = highestMarks;
    }

    public double getLowestMarks() {
        return lowestMarks;
    }

    public void setLowestMarks(double lowestMarks) {
        this.lowestMarks = lowestMarks;
    }
}
