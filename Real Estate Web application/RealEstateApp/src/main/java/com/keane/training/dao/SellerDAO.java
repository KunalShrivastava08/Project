package com.keane.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.keane.training.domain.BookPropertyDetail;
import com.keane.training.domain.PropertyDetails;

public class SellerDAO 
{
	
	
	public static int insertPropertyDetails(final PropertyDetails pd) throws DAOAppException  //seller insert data in property table
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();

			final ParamMapper INSERTPROPERTYDETAILS=new ParamMapper()
			{	

				@Override
				public void mapParams(PreparedStatement preStmt) throws SQLException {
					preStmt.setString(1, pd.getLocation());
					preStmt.setString(2, pd.getType());
					preStmt.setLong(3, pd.getPrice());
					preStmt.setString(4, pd.getAvailable());
					preStmt.setString(5, pd.getEmail());
				}

			};

			result=DBHelper.executeUpdate(con,SQLMapper.INSERTPROPERTYDETAILS,INSERTPROPERTYDETAILS);


		} catch (DBFWException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (DBConnectionException e) {
			e.printStackTrace();
			System.out.println(e);
		}finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}

		return result;
	}

	public static int updateAvailability(int propertyid, String available) throws DAOAppException  
	{
		int result=0;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			final ParamMapper UPDATEAVAILABILITYMAPPER=new ParamMapper()
			{	

				@Override
				public void mapParams(PreparedStatement preStmt) throws SQLException {
					preStmt.setString(1, available);
					preStmt.setInt(2, propertyid);
					
				}
			};

			result=DBHelper.executeUpdate(con,SQLMapper.UPDATEAVAILABILITY,UPDATEAVAILABILITYMAPPER);

		} catch (DBFWException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (DBConnectionException e) {
			e.printStackTrace();
			System.out.println(e);
		}finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}
		return result;
	}



}
