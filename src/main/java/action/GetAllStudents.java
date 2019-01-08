package action;

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

        List<Student> LS = ((StudentDaoImpl) studentDao).getAllStudent();
        response.getWriter().write(ToJson.listToJasonString(LS));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
