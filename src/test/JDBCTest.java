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

        DocDao docDao = new DocDaoImpl();

//        List<StudentGrade> list = docDao.getCourseGrade("1120053", "2017-2018", 2);
//        List<StudentGrade> list1 = docDao.getStudentGrade("16401010222", "2017-2018", 2);
//
//        System.out.println(list.get(0).getScore());
//        System.out.println(list1);
        List<Course>list =  docDao.getCourse();
        System.out.println(list);
    }

}
