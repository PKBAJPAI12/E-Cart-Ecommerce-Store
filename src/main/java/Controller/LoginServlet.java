package Controller;

import Dao.UserDao;
import Model.User;
import helper.FactoryProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws  ServletException, IOException{
response.setContentType("text/html");
try(PrintWriter out=response.getWriter()){
String email=request.getParameter("email");
String password=request.getParameter("password");
    UserDao userDao=new UserDao(FactoryProvider.getFactory());
    User user=userDao.getUserbyEmailAndPassword(email,password);
    //System.out.println(user);
    HttpSession httpSession=request.getSession();
    if(user==null){
      httpSession.setAttribute("message","Invalid Details! Try with Another One");
      response.sendRedirect("login.jsp");
      return;
    }
    else{
        out.println("<h1>Welcome "+user.getUserName()+" </h1>");
        httpSession.setAttribute("current-user",user);
        //for admin page
        if(user.getUserType().equals("admin")){
            response.sendRedirect("admin.jsp");
        }
        //for user page
        else if(user.getUserType().equals("normal")){
            response.sendRedirect("normal.jsp");
        }
        else{
            out.println("We Don;t have Identify User Type");
        }

    }
}


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }




}
