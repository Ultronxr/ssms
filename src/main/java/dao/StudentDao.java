package dao;

import entity.Student;

import java.util.List;

public interface StudentDao {

    Student getStudentInfoById(String id);
    Student getStudentInfoByName(String name);
    List<Student> getAllStudent();
    boolean insertStudent(Student student);
}
