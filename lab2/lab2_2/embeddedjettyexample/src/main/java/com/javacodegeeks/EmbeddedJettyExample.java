package com.javacodegeeks;


import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
 
public class EmbeddedJettyExample {
 
  public static void main(String[] args) throws Exception {
         
    Server server = new Server(8680);       
     
    ServletHandler servletHandler = new ServletHandler();
    server.setHandler(servletHandler);
             
    servletHandler.addServletWithMapping(HelloServlet.class, "/");
     
    server.start();
    server.join();

}
 
public static class HelloServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
      String username = request.getParameter("username");      
        
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();

      // gerar a exceção para ver o que acontece
      /*
      Object obj = null;
      obj.toString();
      */
      if(username == null){
          throw new NullPointerException("Tem que indicar um username para esta página funcionar!");
      }
      else{
          try{
          // Write some content
          out.println("<html>");
          out.println("<head>");
          out.println("<title>FirstApp</title>");
          out.println("</head>");
          out.println("<body>");
          
              if (username.equals("Alexandre")){
                  out.println("<h2>Olá " + username + ", " +"tu já sabes o que vais passar "+ "</h2>");
              }
                  else {
                  out.println("<h2>Olá " + username + ", " +" bem vindo a este mundo"+ "</h2>");
              }  
              
          
          out.println("<h2>Daqui para a frente  vai ser mais complexo mas vais conseguir</h2>");
          out.println("</body>");
          out.println("</html>");
      } finally {
          out.close();
      }
  }
    }
}
}