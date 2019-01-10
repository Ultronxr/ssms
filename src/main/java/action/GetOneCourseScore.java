package action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dao.DocDao;
import dao.impl.DocDaoImpl;
import entity.StudentGrade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//获取选修某门课的学生的成绩
@WebServlet("get_one_course_score")
public class GetOneCourseScore extends HttpServlet {

    private DocDao docDao = new DocDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseId = request.getParameter("CourseId"); //课程ID
        String schoolYear = request.getParameter("SchoolYear"); //学年
        int semester = Integer.parseInt(request.getParameter("Semester")); //学期

        List<StudentGrade> ls =  docDao.getCourseScore(courseId, schoolYear, semester);

        JSONArray array = JSONArray.parseArray(JSON.toJSONString(ls));
        JSONObject json = new JSONObject();
        json.put("result", array);
        output(response,json);

    }

    private void output(HttpServletResponse response,JSONObject json) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
