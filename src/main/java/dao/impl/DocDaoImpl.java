package dao.impl;

import dao.DocDao;
import entity.Course;
import entity.Student;
import entity.StudentGrade;
import utils.MysqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocDaoImpl implements DocDao {

    @Override
    public List<StudentGrade> getStudentGrade(String studentId, String schoolYear, int semester){
        String sql="SELECT school_year,semester,c.id,c.name,c.category,c.credit,sc.course_score,teacher,s.id,s.name,s.sex,s.type,s.institute,s.major,s.grade,s.studentClass\n" +
                "FROM Student s,StudentCourse sc,Course c\n" +
                "WHERE sc.student_id=s.id and c.id=sc.course_id and c.school_year=? and c.semester=? and s.id=?;";
        Connection con = MysqlUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<StudentGrade> list= new ArrayList<>();
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, schoolYear);
            ps.setInt(2, semester);
            ps.setString(3, studentId);
            rs = ps.executeQuery();
            while(rs.next()){
                StudentGrade sg = new StudentGrade();
                sg.setSchoolYear(rs.getString(1));
                sg.setSemester(rs.getString(2));
                sg.setCourseId(rs.getString(3));
                sg.setCourseName(rs.getString(4));
                sg.setCategory(rs.getString(5));
                sg.setCredit(rs.getDouble(6));
                sg.setScore(rs.getInt(7));
                sg.setTeacher(rs.getString(8));
                sg.setStudentId(rs.getString(9));
                sg.setStudentName(rs.getString(10));
                sg.setSex(rs.getString(11));
                sg.setStudentType(rs.getString(12));
                sg.setInstitute(rs.getString(13));
                sg.setMajor(rs.getString(14));
                sg.setGrade(rs.getString(15));
                sg.setStudentClass(rs.getString(16));
                list.add(sg);
            }

        }catch (SQLException e){
            //e.printStackTrace();
            System.out.println("[x] src.main.java.dao.impl-DocDaoImpl-getStudentGrade 连接数据库出错！");
        }finally {
            MysqlUtils.closeConnection(rs, ps, con);
        }
        return list;
    }


    @Override
    public List<StudentGrade> getCourseGrade(String courseId, String schoolYear, int semester){
        String sql = "SELECT sc.course_id, c.school_year, c.semester, sc.course_name, s.grade, sc.student_id, s.name, s.major, s.studentClass, sc.course_score, sc.credit\n" +
                "FROM Student s, StudentCourse sc, Course c\n" +
                "WHERE sc.student_id=s.id and c.id=sc.course_id and sc.course_id=? and c.school_year=? and c.semester=?\n";
        Connection con = MysqlUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<StudentGrade> list = new ArrayList<>();
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, courseId);
            ps.setString(2, schoolYear);
            ps.setInt(3, semester);
            rs = ps.executeQuery();
            while(rs.next()){
                StudentGrade sg = new StudentGrade();
                sg.setCourseId(rs.getString(1));
                sg.setSchoolYear(rs.getString(2));
                sg.setSemester(rs.getString(3));
                sg.setCourseName(rs.getString(4));
                sg.setGrade(rs.getString(5));
                sg.setStudentId(rs.getString(6));
                sg.setStudentName(rs.getString(7));
                sg.setMajor(rs.getString(8));
                sg.setStudentClass(rs.getString(9));
                sg.setScore(rs.getInt(10));
                sg.setCredit(rs.getDouble(11));
                list.add(sg);
            }

        }catch (SQLException e){
            System.out.println("[x] src.main.java.dao.impl-DocDaoImpl-getCourseGrade 连接数据库出错！");
            //e.printStackTrace();
        }finally {
            MysqlUtils.closeConnection(rs, ps, con);
        }
        return list;
    }


    @Override
    public boolean setCourseGrade(List<StudentGrade> list){
        String sql = "UPDATE StudentCourse SET course_score=?\n" +
                "WHERE student_id=? and course_id=?";
        Connection con = MysqlUtils.getConnection();
        PreparedStatement ps = null;
        int flag = 0;
        try{
            ps = con.prepareStatement(sql);

            for(StudentGrade sg : list){
                ps.setInt(1, sg.getScore());
                ps.setString(2, sg.getStudentId());
                ps.setString(3, sg.getCourseId());
                int t = ps.executeUpdate();
                flag += t;
            }

        }catch (SQLException e){
            System.out.println("[x] src.main.java.dao.impl-DocDaoImpl-setCourseGrade 连接数据库出错！");
            //e.printStackTrace();
        }finally {
            MysqlUtils.closeConnection(null, ps, con);
        }
        return true;
    }


    @Override
    public List<Course> getCourse(){

        String sql = "SELECT * FROM Course";
        Connection con = MysqlUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Course> list = new ArrayList<>();
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setId(rs.getString(1));
                course.setSchool_year(rs.getString(2));
                course.setSemester(rs.getInt(3));
                course.setName(rs.getString(4));
                course.setInstitute(rs.getString(5));
                course.setCategory(rs.getString(6));
                course.setCredit(rs.getDouble(7));
                course.setTeacher(rs.getString(8));
                course.setClass_time(rs.getString(9));
                course.setClass_place(rs.getString(10));
                list.add(course);
            }

        }catch (SQLException e){
            System.out.println("[x] src.main.java.dao.impl-DocDaoImpl-getCourse 连接数据库出错！");
            //e.printStackTrace();
        }finally {
            MysqlUtils.closeConnection(rs, ps, con);
        }
        return list;
    }

}
