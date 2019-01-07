package dao;

import entity.StudentGrade;

import java.util.List;

public interface DocDao {
    List<StudentGrade> getStudentGrade(int StudentId);
}
