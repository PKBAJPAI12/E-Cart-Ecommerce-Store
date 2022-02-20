package Controller;

import Model.User;
import helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html");
        try(PrintWriter out=response.getWriter()){
            try {
                String name = request.getParameter("user_name");
                String email = request.getParameter("user_email");
                String password=request.getParameter("user_password");
                String phoneno=request.getParameter("user_phone");
                String address=request.getParameter("user_address");

                User user=new User(name,email,password,phoneno,"default.jpg",address);
                Session hibernateSession= FactoryProvider.getFactory().openSession();
                Transaction tx=hibernateSession.beginTransaction();
                int userId=(int) hibernateSession.save(user);

                tx.commit();
                hibernateSession.close();
                out.println("Successfully Saved");
                out.println("<br> User Id "+ userId);
            } catch (Exception e) {
                e.printStackTrace();
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
