package dao;

import entity.Course;
import entity.Student;
import entity.StudentGrade;

import java.util.List;

public interface DocDao {

    //某个学生在某一学年、某一学期的详细成绩
    List<StudentGrade> getStudentGrade(String studentId);
    List<StudentGrade> getStudentGrade(String studentId,String schoolYear,int semester);
    List<StudentGrade> getStudentGrade();
    //某门课在某一学年、某一学期所有学生的详细成绩
    List<StudentGrade> getCourseScore(String courseId, String schoolYear, int semester);
    //修改某门课某位学生的成绩
    boolean setCourseGrade(String studentId, String courseId, int score);

    //获取课程信息
    List<Course> getCourse();
    List<StudentGrade> getGradeByStudent(String studentId);

}
