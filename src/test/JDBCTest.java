import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import dao.DocDao;
import dao.StudentDao;
import dao.impl.DocDaoImpl;
import dao.impl.StudentDaoImpl;
import entity.Course;
import entity.Student;
import entity.StudentGrade;
import utils.MysqlUtils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {

    public static void main(String[] args){

        new StudentDaoImpl().delStudentById("16401010008");

    }

}
