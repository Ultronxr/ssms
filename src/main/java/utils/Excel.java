package utils;
import dao.StudentDao;
import entity.Student;

import java.util.ArrayList;
import java.util.List;
import jxl.Sheet;
import jxl.Workbook;
import java.io.File;

public class Excel {
    public static List<Student> getAllByExcel(String file){
        List<Student> list=new ArrayList<Student>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet(0);//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行

            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String name=rs.getCell(j++, i).getContents();
                    String age=rs.getCell(j++, i).getContents();
                    String sex=rs.getCell(j++, i).getContents();
                    String insititute=rs.getCell(j++, i).getContents();
                    String major=rs.getCell(j++, i).getContents();
                    String studentClass=rs.getCell(j++, i).getContents();
                    String birthday=rs.getCell(j++, i).getContents();
                    String startTime=rs.getCell(j++, i).getContents();
                    String endTime=rs.getCell(j++, i).getContents();
                    String credit=rs.getCell(j++, i).getContents();
                    String source=rs.getCell(j++, i).getContents();
                    String nationality=rs.getCell(j++, i).getContents();
                    String type=rs.getCell(j++, i).getContents();
                    String politicalStatus=rs.getCell(j++, i).getContents();
                    String gpa=rs.getCell(j++, i).getContents();


                    //list.add(new Student(Integer.parseInt(id), name, sex, Integer.parseInt(num)));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }
}
