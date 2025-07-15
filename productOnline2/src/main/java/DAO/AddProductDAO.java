package DAO;
import java.sql.*;

import Beans.ProductBean;
import DBInfo.DBConnection;
public class AddProductDAO
{
	private static int k=0;
	public int insert(ProductBean pb)
	{
		try
		{
		Connection con=DBConnection.getConnection(); 
		PreparedStatement ps = con.prepareStatement("insert into product55 values(?,?,?,?)");
		ps.setString(1, pb.getCode());
		ps.setString(2, pb.getName());
		ps.setFloat(3, pb.getPrice());
		ps.setInt(4, pb.getQty());
		k=ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	
	
	

}
