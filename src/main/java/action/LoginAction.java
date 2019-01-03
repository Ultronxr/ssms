package action;

import dao.Impl.UserDaoImpl;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginAction extends HttpServlet {

    private UserDao userDao = new UserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        if(userDao.LoginStatus(request.getParameter("username"), request.getParameter("password"))){
            request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
        }
        else{
            response.setContentType("text/html; charset=utf-8");
            PrintWriter pw = response.getWriter();
            pw.write("<script>alert('账户名或密码错误！');history.back();</script>");
            pw.flush();
            //request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
