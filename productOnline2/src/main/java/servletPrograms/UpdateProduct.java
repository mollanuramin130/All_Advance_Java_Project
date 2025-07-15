package servletPrograms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.ProductBean;
import DAO.UpdateProductDAO;
@SuppressWarnings("serial")
@WebServlet("/updateProduct55")
public class UpdateProduct extends HttpServlet 
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			String code = req.getParameter("pcode");
			@SuppressWarnings("unchecked")
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("al");
			Iterator<ProductBean> it = al.iterator();
			while(it.hasNext())
			{
				ProductBean pb=(ProductBean)it.next();
				if(pb.getCode().equals(code))
				{
					pb.setPrice(Float.parseFloat(req.getParameter("price")));
					pb.setQty(Integer.parseInt(req.getParameter("qty")));
					int k=new UpdateProductDAO().update(pb);
					if(k>0)
					{
						req.setAttribute("msg","Product Updated Successfully...<br>");
						req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
					}
					
				}
			}
			
		}
		
	}
		
	

}
