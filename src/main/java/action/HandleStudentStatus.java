package action;

import dao.DocDao;
import dao.StudentDao;
import dao.impl.DocDaoImpl;
import dao.impl.StudentDaoImpl;
import entity.StudentGrade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//更新学生状态按钮
@WebServlet("/handle_student_status")
public class HandleStudentStatus extends HttpServlet {
    private List<StudentGrade>list=null;
    public String getGradeById(String id){
        for(StudentGrade sg:list){
            if (sg.getStudentId().equals(id)){
                return sg.getGrade();
            }
        }
        return null;
    }
    public boolean isgraduate(String grade){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
        Date mydate=null;
        Date nowdate=new Date();
        if(Integer.parseInt(simpleDateFormat.format(nowdate).substring(5,7))>=7 && Integer.parseInt(simpleDateFormat.format(nowdate).substring(0,4))==Integer.parseInt(grade)+4){
            return true;
        }else{
            return false;
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有sc ->list
        DocDao dd=new DocDaoImpl();
        list=dd.getStudentGrade();
        //转化map id为key
        Map<String,Integer>id_num=new HashMap<String,Integer>();
        for(StudentGrade sg:list){
            if(id_num.containsKey(sg.getStudentId())){
                if(sg.getScore()<60) {
                    id_num.put(sg.getStudentId(), id_num.get(sg.getStudentId()) + 1);
                }
            }else{
                id_num.put(sg.getStudentId(),0);
            }
        }
        //处理不及格数的学生
        StudentDao sd=new StudentDaoImpl();
        for (String key : id_num.keySet()){
            //退学5
            if(id_num.get(key)>5){
                sd.updateStatus(key,"退学");
            }
            //不及格3-4
            else if(id_num.get(key)>=3&&id_num.get(key)<5){
                if(!isgraduate(getGradeById(key))) {
                    sd.updateStatus(key, "警示");
                }else{
                    sd.updateStatus(key,"留级");
                }
            }
            //优秀0
            else if(id_num.get(key)==0){
                if(!isgraduate(getGradeById(key))) {
                    sd.updateStatus(key, "优秀");
                }else{
                    sd.updateStatus(key,"毕业");
                }
            }//及格1-2
            else{
                if(!isgraduate(getGradeById(key))) {
                    sd.updateStatus(key,"及格");
                }else{
                    sd.updateStatus(key,"毕业");
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
