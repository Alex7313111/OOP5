package service;

import java.util.List;
import java.util.stream.Collectors;

import model.DB.DataBase;
import model.impl.Student;

public class StudentService {
    public Student createStudent(String name, String lastName, int idgroup){// отвечает только за создание студента (чистый метод)
        int id;
        int size = DataBase.studentsDB.size();
        // id = size + 1;
        if(size == 0){
            id = 1;
        } else {
            id = size + 1;
        }
        Student student = new Student(id, name, lastName, idgroup);
        DataBase.studentsDB.add(student);
        return student;
    }

    public Student getById(int id) throws Exception {
        Student student = DataBase.studentsDB//список студентов
                .stream()//запускаем поток для вычислений
                // пример лямда-выражения (s -> s.getId() == id)
                .filter(s -> s.getId() == id)//вызываем метод filter фильтруя по условию (s = student(переменная))
                .findFirst()//вернуть первого найденого студента
                .orElse(null);// если не нашли вернуть null (orElse закрывет поток stream)
        if (student == null) {
            throw new Exception("Студент не найден");//выбрасываем проверяемое исключение, которое компилятор требует отработать
        }
        return student;
    }
    public List<Student> getId(List<Integer> id) {
        return DataBase.studentsDB
                .stream()
                .filter(s -> id.contains(s.getId()))
                .collect(Collectors.toList());
    }

    public List<Student> getAllStudents(){
        return DataBase.studentsDB;
    }
}
