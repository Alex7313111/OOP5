package service;

import model.impl.Student;
import model.impl.StudentGroup;
import model.impl.Teacher;

import java.util.List;

public class StudentGroupService {
    public StudentGroup createGroup(Teacher teacher, List<Student> students){
        return new StudentGroup(teacher, students);
    }
}
