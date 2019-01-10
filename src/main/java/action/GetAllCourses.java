package action;

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
import java.util.List;

//获取所有课程信息
@WebServlet("/get_all_courses")
public class GetAllCourses extends HttpServlet {

    private DocDao docDao = new DocDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> ls = docDao.getCourse();
        request.setAttribute("CourseInfoList", ls);
        request.setAttribute("Flag", 2);

        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
