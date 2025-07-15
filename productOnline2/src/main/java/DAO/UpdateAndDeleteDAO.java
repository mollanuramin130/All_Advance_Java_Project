package DAO;
import java.sql.*;

import Beans.ProductBean;
import DBInfo.DBConnection;
public class UpdateAndDeleteDAO 
{
	public int UpdateStack(ProductBean pb,int qty)
	{
		int k=0;
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Update product55 set qty=? where code=?");
			ps.setString(2, pb.getCode());
			ps.setInt(1, (pb.getQty()- qty));
			k=ps.executeUpdate();
		} 
		catch (Exception e) {
			
		}
		return k;
	}

}
