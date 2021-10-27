package com.tomcat_21.app;
 
import java.io.IOException;
import java.io.PrintWriter;

 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "App", urlPatterns = {"/firstApp"})
public class App extends HttpServlet {
 
    private static final long serialVersionUID = -1915463532411657451L;
 
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
         
        String username = request.getParameter("username");      
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // Write some content
            out.println("<html>");
            out.println("<head>");
            out.println("<title>FirstApp</title>");
            out.println("</head>");
            out.println("<body>");
         
            
            if (username != null){
                out.println("<h2>Olá " + username + ", " +" bem vindo a este mundo"+ "</h2>");
            }
           
            else{
                out.println("<h2>Olá anónimo " +", " + "bem vindo a este mundo" + "</h2>");
            }
            
            out.println("<h2>Daqui para a frente já vai ser mais complexo mas vais conseguir</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
     

}