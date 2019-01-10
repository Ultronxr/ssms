package action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;
import utils.ToJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/get_all_students")
public class GetAllStudents extends HttpServlet {

    private StudentDao studentDao = new StudentDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Student> ls = studentDao.getAllStudent();
        request.setAttribute("StudentInfoList", ls);
        request.setAttribute("Flag", 1);

        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
        //response.getWriter().write(ToJson.listToJasonString(LS));
        /*JSONArray array = JSONArray.parseArray(JSON.toJSONString(ls));
        JSONObject json = new JSONObject();
        json.put("data", array);
        json.put("sEcho", 1);
        json.put("iTotalRecords", ls.size());
        json.put("iTotalDisplayRecords", 2);
        response.getWriter().write(json.toJSONString());
        System.out.println(json.toJSONString());*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
