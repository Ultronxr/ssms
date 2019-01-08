package dao.impl;

import dao.DocDao;
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
    public List<StudentGrade> getStudentGrade(String StudentId,String schoolYear,String semester){
        String sql="SELECT school_year,semester,c.id,c.name,c.category,c.credit,sc.course_grade,teacher,s.id,s.name,s.sex,s.type,s.institute,s.major,s.grade,s.studentClass\n" +
                "FROM Student s,StudentCourse sc,Course c\n" +
                "WHERE sc.student_id=s.id and c.id=sc.course_id and c.school_year=? and c.semester=? and s.id=?;";
        Connection con = MysqlUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<StudentGrade> list= new ArrayList<>();
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, schoolYear);
            ps.setString(2, semester);
            ps.setString(3, StudentId);
            rs = ps.executeQuery();
            if(rs.next()){
                StudentGrade sg = new StudentGrade();
                sg.setSchoolYear(rs.getString(0));
                sg.setSemester(rs.getString(1));
                sg.setCourseId(rs.getString(2));
                sg.setCourseName(rs.getString(3));
                sg.setCategory(rs.getString(4));
                sg.setCredit(rs.getDouble(5));
                sg.setScore(rs.getInt(6));
                sg.setTeacher(rs.getString(7));
                sg.setStudentId(rs.getString(8));
                sg.setStudentName(rs.getString(9));
                sg.setSex(rs.getString(10));
                sg.setStudentType(rs.getString(11));
                sg.setInstitute(rs.getString(12));
                sg.setMajor(rs.getString(13));
                sg.setGrade(rs.getString(14));
                sg.setStudentClass(rs.getString(15));
            }

        }catch (SQLException e){
            System.out.println("[x] src.main.java.dao.impl-StudentDaoImpl 通过学号获取学生实体类时，连接数据库出错！");
        }finally {
            MysqlUtils.closeConnection(rs, ps, con);
        }
        return list;
    }
}
