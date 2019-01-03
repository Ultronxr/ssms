package dao.impl;

import dao.StudentDao;
import entity.Student;
import utils.MysqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao {

    @Override
    public Student getStudentInfoById(String id){

        Student student = null;
        String sql="SELECT * FROM Student WHERE id=?";
        Connection con = MysqlUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                student = new Student();
                student.setId(rs.getString("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setSex(rs.getString("sex"));
                student.setInstitute(rs.getString("institute"));
                student.setMajor(rs.getString("major"));
                student.setStudentClass(rs.getString("studentClass"));
                student.setBirthday(rs.getString("birthday"));
                student.setStartTime(rs.getString("startTime"));
                student.setEndTIme(rs.getString("endTime"));
                student.setCredit(rs.getInt("credit"));
                student.setSource(rs.getString("source"));
                student.setNationality(rs.getString("nationality"));
                student.setType(rs.getString("type"));
                student.setPoliticalStatus(rs.getString("politicalStatus"));
                student.setGpa(rs.getDouble("gpa"));
            }

        }catch (SQLException e){
            System.out.println("[x] src.main.java.dao.impl-StudentDaoImpl 通过学号获取学生实体类时，连接数据库出错！");
        }finally {
            MysqlUtils.closeConnection(rs, ps, con);
        }
        return student;
    }


}
