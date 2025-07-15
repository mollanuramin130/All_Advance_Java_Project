package servletPrograms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DeleteProductDAO;
@SuppressWarnings("serial")
@WebServlet("/deleteproduct")
public class DeleteProduct extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession ht = req.getSession(false);
		if(ht==null)
		{
			req.setAttribute("msg","Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			String code=req.getParameter("pcode");
			int k=new DeleteProductDAO().delete(code);
			if(k>0)
			{
				req.setAttribute("msg","Product Successfully Deleted...<br>");
				req.getRequestDispatcher("delete.jsp").forward(req, res);
			}
			
			
		}
		
	}

}
