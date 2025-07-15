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
@SuppressWarnings("serial")
@WebServlet("/billProduct")
public class BillProduct extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			String code=req.getParameter("pcode");
			@SuppressWarnings("unchecked")
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("al");
			Iterator<ProductBean> it = al.iterator();
			while (it.hasNext()) {
				ProductBean pb = (ProductBean) it.next();
				if(pb.getCode().equals(code))
				{
					req.setAttribute("pb", pb);
					int reqqty=Integer.parseInt(req.getParameter("reqqty"));
					float totalAmount=pb.getPrice()*reqqty;
					req.setAttribute("reqqty",reqqty);
					req.setAttribute("totAmt",totalAmount);
					break;
				}
				
			}
			req.getRequestDispatcher("BillProduct.jsp").forward(req, res);
		}
	}

}
