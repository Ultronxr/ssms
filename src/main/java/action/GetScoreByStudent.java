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

@WebServlet("/get_score_by_student")
public class GetScoreByStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DocDao dd=new DocDaoImpl();
        String studentid=request.getParameter("studentId");
        List<StudentGrade>list=dd.getGradeByStudent(studentid);
        JSONArray array = JSONArray.parseArray(JSON.toJSONString(list));
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
