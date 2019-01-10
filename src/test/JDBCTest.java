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

        Student student = new Student("16401010222", "方材", 21, "男", "电子与信息", "计科", "162", "1998-01-01", "2016-09-15", "2016", 88, "在读", "浙江", "汉", "普通本科生", "群众", 3.75);
        new StudentDaoImpl().updateStudent(student);

    }

}
