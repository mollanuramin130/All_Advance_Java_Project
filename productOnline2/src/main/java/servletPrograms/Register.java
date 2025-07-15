package servletPrograms;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.CustomerBean;
import DAO.RegisterCustomerDAO;
@SuppressWarnings("serial")
@WebServlet("/reg")
public class Register extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		HttpSession hs=req.getSession();
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
		String un = req.getParameter("us");
		String ps = req.getParameter("pa");
		String fn = req.getParameter("fn");
		String ln = req.getParameter("ln");
		String mid = req.getParameter("mid");
		Long phno=Long.parseLong(req.getParameter("phno"));
		CustomerBean cb =new CustomerBean();
		cb.setUserName(un);
		cb.setPassWord(ps);
		cb.setFirstName(fn);
		cb.setLastName(ln);
		cb.setEmail(mid);
		cb.setMobile(phno);
		int k=new RegisterCustomerDAO().insert(cb);
		if(k>0)
		{
			req.setAttribute("msg","Register Succefull...<br>");
			req.getRequestDispatcher("RegisterSuccess.jsp").forward(req, res);
		}
		
		}
	}

}
