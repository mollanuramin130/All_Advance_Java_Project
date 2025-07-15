package servletPrograms;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.UserBean;
import DAO.UserDAO;
@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLogin extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		UserBean ub=new UserDAO().userValid(req.getParameter("uname"), req.getParameter("pword"));
		if(ub==null)
		{
			req.setAttribute("msg","UserName/PassWord is wrong");
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		
		}
		
		else
		{
			HttpSession ht = req.getSession();
			ht.setMaxInactiveInterval(1000);
			ht.setAttribute("ubean",ub);
			req.setAttribute("msg","welcome user :");
			RequestDispatcher rd = req.getRequestDispatcher("AdminLoginSuccess.jsp");
			rd.forward(req, res);
		}
		
	}

}
