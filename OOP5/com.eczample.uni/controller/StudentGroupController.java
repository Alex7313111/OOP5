package controller;

import model.impl.Student;
import model.impl.StudentGroup;
import model.impl.Teacher;
import service.StudentGroupService;
import service.StudentService;
import service.TeacherService;

import java.util.List;

public class StudentGroupController {
    private StudentService studentService = new StudentService();
    private TeacherService teacherService = new TeacherService();
    private StudentGroupService groupService = new StudentGroupService();


    public StudentGroup createGroup(int teacherId, List<Integer> studentId) {
        Teacher teacher = teacherService.getId(teacherId);
        List<Student> students = studentService.getId(studentId);
        return groupService.createGroup(teacher, students);
    }
}
