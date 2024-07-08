package model.impl;

import model.DB.DataBase;

import java.util.ArrayList;
import java.util.List;

public class StudentGroup {
  private   Teacher teacher;
    private List<Student> students;


    public StudentGroup (Teacher teacher, List<Student> students){
        this.teacher = teacher;
        this.students = students;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public List<Student> getStudents() {
        return students;
    }
    @Override
    public String toString() {
        return String.format("Преподаватель: %s, студенты: %s", teacher, students);
    }

}
