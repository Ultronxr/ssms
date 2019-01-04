import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import entity.Student;
import utils.MysqlUtils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {
    /***
     * 阿里云防火墙设置3306开放
     * /etc/mysql/mysql.conf.d/mysqld.cnf注释bind-host一行
     * https://blog.csdn.net/qq_39781497/article/details/81302950
     */

    public static void main(String[] args){
        Student a=new Student();
//        a.setId("id");
//        a.setName("name");
//        a.setAge(21);
//        a.setSex("sex");
//        a.setInstitute("institute");
//        a.setMajor("major");
//        a.setStudentClass("studentClass");
//        a.setBirthday("birthday");
//        a.setStartTime("startTime");
//        a.setEndTIme("endTime");
//        a.setCredit(88);
//        a.setSource("source");
//        a.setNationality("nationality");
//        a.setType("type");
//        a.setPoliticalStatus("politicalStatus");
//        a.setGpa(3.75);
        Student b=new Student();
//        b.setId("2");
        List<Student> ls=new ArrayList<Student>();
        ls.add(a);
        ls.add(b);
        System.out.println(JSON.toJSONString(ls, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty));
    }

}
