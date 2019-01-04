package action;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;
import utils.ToJason;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/get_all_students")
public class getAllStudents extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao sdao=new StudentDaoImpl();
        List<Student> LS=((StudentDaoImpl) sdao).getAllStudent();
        ToJason jason=new ToJason();
        response.getWriter().write(jason.listToJasonString(LS));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
