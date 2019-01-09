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

        if(category.equals("UpdateScore")){
            String json = request.getParameter("list");
            List<StudentGrade> list =  JSONObject.parseArray(json, StudentGrade.class);
            docDao.setCourseGrade(list);
        }
        if(category.equals("UpdateStudentInfo")){

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
