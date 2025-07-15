package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Beans.ProductBean;
import DBInfo.DBConnection;

public class UpdateProductDAO
{
	public int update(ProductBean pb)
	{
		int k=0;
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Update product55 set price=?,qty=? where code=?");
			ps.setFloat(1,pb.getPrice());
			ps.setInt(2, pb.getQty());
			ps.setString(3,pb.getCode());
			k=ps.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
