package dao;

import entity.Student;

import java.util.List;

public interface StudentDao {

    Student getStudentInfoById(String id);
    Student getStudentInfoByName(String name);
    List<Student> getAllStudent();

    //通过年级、专业、班级获取学生信息
    List<Student> getStudentInfoByCon(String grade, String major, String studentClass);


    boolean insertStudent(Student student);
    boolean delStudentById(String id);


}
