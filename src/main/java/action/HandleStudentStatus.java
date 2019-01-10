package action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.nio.sctp.HandlerResult;
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
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

//更新学生状态按钮
@WebServlet("/handle_student_status")
public class HandleStudentStatus extends HttpServlet {
    public class HandleStudent{
        String id;
        String name;
        String studentType;
        String institute;
        String major;
        String grade;
        String studentClass;
        String sex;
        int num;
        String result;
        public HandleStudent(){};
        public HandleStudent(String id, String name, String studentType, String institute, String major, String grade, String studentClass, String sex, int num, String result) {
            this.id = id;
            this.name = name;
            this.studentType = studentType;
            this.institute = institute;
            this.major = major;
            this.grade = grade;
            this.studentClass = studentClass;
            this.sex = sex;
            this.num = num;
            this.result = result;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getStudentType() {
            return studentType;
        }

        public String getInstitute() {
            return institute;
        }

        public String getMajor() {
            return major;
        }

        public String getGrade() {
            return grade;
        }

        public String getStudentClass() {
            return studentClass;
        }

        public String getSex() {
            return sex;
        }

        public int getNum() {
            return num;
        }

        public String getResult() {
            return result;
        }
    }
    private List<StudentGrade>list=null;
    public String getGradeById(String id){
        for(StudentGrade sg:list){
            if (sg.getStudentId().equals(id)){
                return sg.getGrade();
            }
        }
        return null;
    }
    public StudentGrade getSGById(String id){
        for(StudentGrade sg:list){
            if (sg.getStudentId().equals(id)){
                return sg;
            }
        }
        return null;
    }
    public boolean isgraduate(String grade){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
        Date mydate=null;
        Date nowdate=new Date();
        if(Integer.parseInt(simpleDateFormat.format(nowdate).substring(5,7))>=7 && Integer.parseInt(simpleDateFormat.format(nowdate).substring(0,4))>=Integer.parseInt(grade)+4){
            return true;
        }else{
            return false;
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有sc ->list
        DocDao dd=new DocDaoImpl();
        list=dd.getStudentGrade();
        List<HandleStudent>handleResult=new ArrayList<HandleStudent>();
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
            StudentGrade sg=getSGById(key);
            //退学5
            if(id_num.get(key)>5){
                sd.updateStatus(key,"退学");
                HandleStudent hs=new HandleStudent(key,sg.getStudentName(),sg.getStudentType(),sg.getInstitute(),sg.getMajor(),sg.getGrade(),sg.getStudentClass(),sg.getSex(),id_num.get(key),"退学");
                handleResult.add(hs);
            }
            //不及格3-4
            else if(id_num.get(key)>=3&&id_num.get(key)<5){
                if(!isgraduate(getGradeById(key))) {
                    sd.updateStatus(key, "警示");
                    HandleStudent hs=new HandleStudent(key,sg.getStudentName(),sg.getStudentType(),sg.getInstitute(),sg.getMajor(),sg.getGrade(),sg.getStudentClass(),sg.getSex(),id_num.get(key),"警示");
                    handleResult.add(hs);
                }else{
                    sd.updateStatus(key,"留级");
                    HandleStudent hs=new HandleStudent(key,sg.getStudentName(),sg.getStudentType(),sg.getInstitute(),sg.getMajor(),sg.getGrade(),sg.getStudentClass(),sg.getSex(),id_num.get(key),"留级");
                    handleResult.add(hs);
                }
            }
            //优秀0
            else if(id_num.get(key)==0){
                if(!isgraduate(getGradeById(key))) {
                    sd.updateStatus(key, "优秀");
                    HandleStudent hs=new HandleStudent(key,sg.getStudentName(),sg.getStudentType(),sg.getInstitute(),sg.getMajor(),sg.getGrade(),sg.getStudentClass(),sg.getSex(),id_num.get(key),"优秀");
                    handleResult.add(hs);
                }else{
                    sd.updateStatus(key,"毕业");
                    HandleStudent hs=new HandleStudent(key,sg.getStudentName(),sg.getStudentType(),sg.getInstitute(),sg.getMajor(),sg.getGrade(),sg.getStudentClass(),sg.getSex(),id_num.get(key),"毕业");
                    handleResult.add(hs);
                }
            }//及格1-2
            else{
                if(!isgraduate(getGradeById(key))) {
                    sd.updateStatus(key,"及格");
                    HandleStudent hs=new HandleStudent(key,sg.getStudentName(),sg.getStudentType(),sg.getInstitute(),sg.getMajor(),sg.getGrade(),sg.getStudentClass(),sg.getSex(),id_num.get(key),"及格");
                    handleResult.add(hs);
                }else{
                    sd.updateStatus(key,"毕业");
                    HandleStudent hs=new HandleStudent(key,sg.getStudentName(),sg.getStudentType(),sg.getInstitute(),sg.getMajor(),sg.getGrade(),sg.getStudentClass(),sg.getSex(),id_num.get(key),"毕业");
                    handleResult.add(hs);
                }
            }
        }
        JSONArray array = JSONArray.parseArray(JSON.toJSONString(handleResult));
        JSONObject json = new JSONObject();
        json.put("data", array);
        output(response,json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private void output(HttpServletResponse response, JSONObject json) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        PrintWriter out = response.getWriter();
        out.println(json.toJSONString());
        out.flush();
        out.close();
    }
}
