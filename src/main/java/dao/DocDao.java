package dao;

import entity.StudentGrade;

import java.util.List;

public interface DocDao {
    List<StudentGrade> getStudentGrade(String StudentId,String schoolYear,String semester);
}
