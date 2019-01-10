package action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dao.DocDao;
import dao.StudentDao;
import dao.impl.DocDaoImpl;
import dao.impl.StudentDaoImpl;
import entity.Student;
import entity.StudentGrade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateInfos")
public class UpdateInfos extends HttpServlet {

    private DocDao docDao = new DocDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("Category");

        //修改成绩
        if(category.equals("UpdateScore")){
            String json = request.getParameter("json");
            List<StudentGrade> list =  JSONObject.parseArray(json, StudentGrade.class);
            docDao.setCourseGrade(list);
        }
        //修改学生信息
        if(category.equals("UpdateStudentInfo")){
            Student student = new Student(
                    request.getParameter("sid"),
                    request.getParameter("sname"),
                    Integer.parseInt(request.getParameter("sage")),
                    request.getParameter("ssex"),
                    request.getParameter("sinstitute"),
                    request.getParameter("smajor"),
                    request.getParameter("sclass"),
                    request.getParameter("sbirthday"),
                    request.getParameter("sstartTime"),
                    request.getParameter("sgrade"),
                    Double.parseDouble(request.getParameter("scredit")),
                    request.getParameter("sstatus"),
                    request.getParameter("ssource"),
                    request.getParameter("snationality"),
                    request.getParameter("stype"),
                    request.getParameter("spoliticalStatus"),
                    Double.parseDouble(request.getParameter("sgpa"))
            );
            //System.out.println(student.toString());
            studentDao.updateStudent(student);
            response.getWriter().write("{\"result\":\"1\"}");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
