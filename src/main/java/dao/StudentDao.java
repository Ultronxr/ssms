package dao;

import entity.Student;

import java.util.List;

public interface StudentDao {

    Student getStudentInfoById(String id);
    Student getStudentInfoByName(String name);
    List<Student> getAllStudent();

    //通过入学时间、专业、班级获取学生信息
    //List<Student> getStudentInfoByCon(String startTime, String major, String studentClass);


    boolean insertStudent(Student student);
    boolean delStudentById(String id);


}
