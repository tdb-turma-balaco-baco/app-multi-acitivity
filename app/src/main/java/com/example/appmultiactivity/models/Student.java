package com.example.appmultiactivity.models;

public class Student {
    private String name;
    private Double firstGrade;
    private Double secondGrade;
    private int frequency;
    private Double finalGrade;

    public Student(String name, double firstGrade, double secondGrade, int frequency) {
        this.name = name;
        this.firstGrade = firstGrade;
        this.secondGrade = secondGrade;
        this.frequency = frequency;
        this.finalGrade = calculateSemesterAverage();
    }

    public Double getFinalGrade() {
        return finalGrade;
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

    private Double calculateSemesterAverage(){
        return (firstGrade + secondGrade) / 2;
    }
}
