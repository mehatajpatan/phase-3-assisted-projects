index.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <form action="login" method="post">
                <input type=hidden name="userid" id="userid" value="admin">
          <button>Dashboard with hidden form fields login</button>
        </form>
        <br><br>  
        <a href="dashboard">Dashboard without hidden form fields login</a>
</body>
</html>
-----------------------------------------------------------------------------

LoginServlet


import java.io.*;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;



/**
* Servlet implementation class LoginServlet
*/
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
* @see HttpServlet#HttpServlet()
*/
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                 PrintWriter out = response.getWriter();
                 out.println("<html><body>");
                    
                 String userId = request.getParameter("userid");
                 //creating a new hidden form field
                out.println("<form action='dashboard' method='post'>");
                out.println("<input type='hidden' name='userid' id='userid' value='"+userId+"'>");
                out.println("<input type='submit' value='submit' >");
                out.println("</form>");
                out.println("<script>document.forms[0].submit();</script>");
              
                
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }

}



------------------------------------------------------------------------------------------------------------------------------

Dashboard

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;



/**
* Servlet implementation class Dashboard
*/
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
* @see HttpServlet#HttpServlet()
*/
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
        
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            String userId = request.getParameter("userid");
            if (userId == null) {
                out.println("No UserId was found in hidden form field.<br>");
            } else {
                out.println("UserId found in hidden form field: " + userId + "<br>");
                
            }
            out.println("</body></html>");

        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }

}
----------------------------------------------------------------------------------------------------------------------------------

web.xml


<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" id="WebApp_ID" version="4.0">
  <display-name>FormFieldsTracking</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  
  <servlet>
    <servlet-name>LoginServlet</servlet-name>
    <servlet-class>LoginServlet</servlet-class>
  </servlet>
  <servlet>
    <servlet-name>Dashboard</servlet-name>
    <servlet-class>Dashboard</servlet-class>
  </servlet>
 
  <servlet-mapping>
    <servlet-name>Dashboard</servlet-name>
    <url-pattern>/dashboard</url-pattern>
  </servlet-mapping>
   <servlet-mapping>
    <servlet-name>LoginServlet</servlet-name>
    <url-pattern>/login</url-pattern>
  </servlet-mapping>
</web-app>

