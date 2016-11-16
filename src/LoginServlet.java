import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** * Servlet implementation class LoginServlet */
public class LoginServlet extends HttpServlet {
	StringBuilder htmlBuilder = new StringBuilder();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException { 
		try { 
			
			if((request.getParameter("un").equals("Rahul") || request.getParameter("un").equals("Suresh")) && request.getParameter("pw").equals("MySel@123")){
				response.sendRedirect("userLogged.jsp");
			}else{
				response.sendRedirect("Logout.jsp");
			}
		} catch (Throwable theException) { 
			System.out.println(theException);
		}
	}
}