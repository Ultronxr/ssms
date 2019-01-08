package action;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;
import utils.Excel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/import.jhtml")
public class importFromExcel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println(request.getPart("file").getContentType());
        InputStream is=request.getPart("file").getInputStream();
        String name=request.getPart("file").getSubmittedFileName();
        System.out.println("name:"+name);
        int i;
        String realfilepath=request.getServletContext().getRealPath("/image/"+name);
        System.out.println("filepath:"+realfilepath);
        FileOutputStream fos2=new FileOutputStream(realfilepath);
        byte[] buf=new byte[1024];
        while((i = is.read(buf)) != -1) {
            fos2.write(buf,0,i);
        }
        System.out.println("执行完成");
        List<Student>list=Excel.getAllByExcel(realfilepath);
        StudentDao sd=new StudentDaoImpl();
        for(int j=0;j<list.size();++j){
            sd.insertStudent(list.get(j));
        }
        response.getWriter().write("{\"result\":\"1\"}");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
