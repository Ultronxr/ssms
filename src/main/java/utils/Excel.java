package utils;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;

import java.util.ArrayList;
import java.util.List;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

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

                    Student st=new Student(id,name,Integer.parseInt(age),sex,insititute,major,studentClass,birthday,startTime,endTime,Double.parseDouble(credit),source,nationality,type,politicalStatus,Double.parseDouble(gpa));
                    list.add(st);
                    //list.add(new Student(Integer.parseInt(id), name, sex, Integer.parseInt(num)));
                }
            }
            System.out.println("find "+ list.size()+" students in excel!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    public static boolean dbToExcel(String fileName){
        try {
            WritableWorkbook wwb = null;
            // 创建可写入的Excel工作簿
            File file=new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            //以fileName为文件名来创建一个Workbook
            wwb = Workbook.createWorkbook(file);

            // 创建工作表
            WritableSheet ws = wwb.createSheet("Test Shee 1", 0);

            //查询数据库中所有的数据
            //List<StuEntity> list= StuService.getAllByDb();
            //要插入到的Excel表格的行号，默认从0开始
            Label labelSchoolYear= new Label(0, 0, "学年");//表示第
            Label labelSemester= new Label(1, 0, "学期");
            Label labelCourseId= new Label(2, 0, "课程代码");
            Label labelCourseName= new Label(3, 0, "课程名称");
            Label labelCategory=new Label(4,0,"课程性质");
            Label labelCredit=new Label(5,0,"学分");
            Label labelScore=new Label(6,0,"成绩");
            Label labelTeacher=new Label(7,0,"任课教师");
            Label labelStudentId=new Label(8,0,"学号");
            Label labelStudentName=new Label(9,0,"姓名");
            Label labelSex=new Label(10,0,"性别");
            Label labelType=new Label(11,0,"学生类别");
            Label labelInstitute=new Label(12,0,"学院");
            Label labelMajor=new Label(13,0,"专业");
            Label labelGrade=new Label(14,0,"年级");
            Label labelClass=new Label(15,0,"班级");
            ws.addCell(labelSchoolYear);
            ws.addCell(labelSemester);
            ws.addCell(labelCourseId);
            ws.addCell(labelCourseName);
            ws.addCell(labelCategory);
            ws.addCell(labelCredit);
            ws.addCell(labelScore);
            ws.addCell(labelTeacher);
            ws.addCell(labelStudentId);
            ws.addCell(labelStudentName);
            ws.addCell(labelSex);
            ws.addCell(labelType);
            ws.addCell(labelInstitute);
            ws.addCell(labelMajor);
            ws.addCell(labelGrade);
            ws.addCell(labelClass);

//            for (int i = 0; i < list.size(); i++) {
//
//                Label labelId_i= new Label(0, i+1, list.get(i).getId()+"");
//                Label labelName_i= new Label(1, i+1, list.get(i).getName());
//                Label labelSex_i= new Label(2, i+1, list.get(i).getSex());
//                Label labelNum_i= new Label(3, i+1, list.get(i).getNum()+"");
//                ws.addCell(labelId_i);
//                ws.addCell(labelName_i);
//                ws.addCell(labelSex_i);
//                ws.addCell(labelNum_i);
//            }

            //写进文档
            wwb.write();
            // 关闭Excel工作簿对象
            wwb.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
}
