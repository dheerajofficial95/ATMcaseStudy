package base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String why = request.getParameter("why");
		String pageName = "login.jsp";
		
		if(why.equals("login"))
		{
			Logic x =new Logic();
			pageName = x.getDoLogin(request);
		}
		else if(why.equals("viewBal"))
		{
			Logic x = new Logic();
			pageName = x.getBalance(request);
		}
		else if(why.equals("withdraw"))
		{
			Logic x = new Logic();
			pageName = x.getWithdraw(request);
		}
		else if(why.equals("deposit"))
		{
			Logic x = new Logic();
			pageName = x.getdeposit(request);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(pageName);
		rd.forward(request, response);
	}

}
