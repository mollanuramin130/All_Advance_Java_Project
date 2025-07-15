package servletPrograms;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.ProductBean;
import DAO.AddProductDAO;
@SuppressWarnings("serial")
@WebServlet("/addproduct")
public class AddProductData extends HttpServlet
{

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			String code = req.getParameter("code");
			String name = req.getParameter("name");
			float price = Float.parseFloat(req.getParameter("price"));
			int qty =Integer.parseInt(req.getParameter("qty"));
			ProductBean pb=new ProductBean();
			pb.setCode(code);
			pb.setName(name);
			pb.setPrice(price);
			pb.setQty(qty);
			int k = new AddProductDAO().insert(pb);
			if(k>0)
			{
				req.setAttribute("msg","Product Successfully Added...<br>");
				RequestDispatcher rd=req.getRequestDispatcher("AddProduct.jsp");
				rd.include(req, res);
			}
		}
	}

}
