package servletPrograms;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Beans.ProductBean;
import DAO.FetchingProductDAO;

@SuppressWarnings("serial")
@WebServlet("/viewProducts")
public class ViewAllProducts extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		HttpSession ht=req.getSession(false);
		if(ht==null)
		{
			req.setAttribute("msg","Session Expired..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
		   ArrayList<ProductBean> al =new FetchingProductDAO().view();
			ht.setAttribute("al", al);
			req.getRequestDispatcher("ViewProduct.jsp").forward(req, res);
	  }
    }

	
}
