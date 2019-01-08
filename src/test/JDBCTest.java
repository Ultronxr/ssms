import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;
import utils.MysqlUtils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {

    public static void main(String[] args){

        StudentDao studentDao = new StudentDaoImpl();
        List<Student> temp = new ArrayList<>();
        temp = studentDao.getStudentInfoByCon("2016", "计科", "162");
        System.out.println(temp);

    }

}
