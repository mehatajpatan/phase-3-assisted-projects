index.html


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Name Servlet</title>
</head>
<body>
        <center>
                <form name=frmName method="GET" action="name">
                        <table width="50%" border="0">
                                <tr valign="top">
                                        <td width="40%">Enter your firstname</td>
                                        <td><input name="fname" id="fname" maxlength=30></td>
                                </tr>
                                <tr valign="top">
                                        <td width="40%">Enter your lastname</td>
                                        <td><input name="lname" id="lname" maxlength=30></td>
                                </tr>
                                        <tr valign="top">
                                        <td colspan=2 width="100%">
                                                <button>Submit</button>
                                        </td>
                                        
                                </tr>
                        </table>
                </form>
        </center>
</body>
</html>
-------------------------------------------------------------------------------------------------------------

NameServlet



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class NameServlet
*/
@WebServlet("/NameServlet")
public class NameServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
* @see HttpServlet#HttpServlet()
*/
    public NameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                
                PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("Your full name is " + fname + " " + lname);
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


---------------------------------------------------------------------------------------------------------



web.xml




<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" id="WebApp_ID" version="4.0">
  <display-name>ServletDemo</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  
  <servlet>
        <servlet-name>NameServlet</servlet-name>
        <servlet-class>NameServlet</servlet-class>
  </servlet>

  <servlet-mapping>
        <servlet-name>NameServlet</servlet-name>
        <url-pattern>/name</url-pattern>
   </servlet-mapping>

</web-app>


