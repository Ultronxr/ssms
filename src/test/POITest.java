import entity.Student;
import entity.StudentGrade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class POITest {
    public boolean isgraduate(StudentGrade student){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
        Date mydate=null;
        Date nowdate=new Date();
        if(Integer.parseInt(simpleDateFormat.format(nowdate).substring(5,7))>=7 && Integer.parseInt(simpleDateFormat.format(nowdate).substring(0,4))==Integer.parseInt(student.getGrade())+4){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String [] args){
        String mytime="1998-06-09";
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd");

        Date date2=new Date();
        System.out.println(simpleDateFormat.format(date2));
        System.out.println(simpleDateFormat.format(date2).substring(5,7));
        System.out.println(simpleDateFormat.format(date2).substring(0,4));
        if(Integer.parseInt(simpleDateFormat.format(date2).substring(5,7))==1 && Integer.parseInt(simpleDateFormat.format(date2).substring(0,4))==2015+4){
            System.out.println("biye");
        }
    }
}
