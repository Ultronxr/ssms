package action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dao.DocDao;
import dao.impl.DocDaoImpl;
import dao.impl.StudentDaoImpl;
import entity.Course;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//获取所有课程信息
@WebServlet("/get_all_courses")
public class GetAllCourses extends HttpServlet {

    private DocDao docDao = new DocDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> ls = docDao.getCourse();
        String draw="1";
        JSONArray array = JSONArray.parseArray(JSON.toJSONString(ls));
        JSONObject json = new JSONObject();
        json.put("data",array);
        System.out.println(json.toJSONString());
        output(response,json);
//        request.setAttribute("CourseInfoList", ls);
//        request.setAttribute("Flag", 2);
//
//        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void output(HttpServletResponse response,JSONObject json) throws IOException {
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
