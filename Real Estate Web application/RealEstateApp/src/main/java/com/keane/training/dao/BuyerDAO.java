package com.keane.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.ParamMapper;
import com.keane.training.domain.PropertyDetails;
import com.keane.training.domain.BookPropertyDetail;


public class BuyerDAO {
	
	public static List getPrice(int propetyid) throws DAOAppException 
	{
		List listprice=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			final ParamMapper GETEMAILMAPPER=new ParamMapper()
			{

				@Override
				public void mapParams(PreparedStatement preStmt) throws SQLException {
					preStmt.setInt(1,propetyid);
				}

			};//ananymous class

			listprice=DBHelper.executeSelect
					(con,SQLMapper.FETCHPRICE,SQLMapper.ALLPROPERTYMAPPER, GETEMAILMAPPER );		

		} catch (DBConnectionException | DBFWException e) {
			System.out.println(e);
			e.printStackTrace();
		}finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}

		return listprice;

	}
	
	public static List getAvailableProperty(final PropertyDetails pd) throws DAOAppException// get available properties from DataBase
	{
		List listofproperty=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			final ParamMapper AVAILABLEPROPERTYMAPPER=new ParamMapper()
			{

				@Override
				public void mapParams(PreparedStatement preStmt) throws SQLException {
					preStmt.setString(1,pd.getLocation());
					preStmt.setString(2,pd.getType());
					preStmt.setLong(3,pd.getPrice());
					
				}

			};//ananymous class

			listofproperty=DBHelper.executeSelect
					(con, SQLMapper.FETCHAVAILABLEPROPERTY,SQLMapper.ALLPROPERTYMAPPER, AVAILABLEPROPERTYMAPPER);		

		} catch (DBConnectionException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (DBFWException e) {
			System.out.println(e);
			e.printStackTrace();
		}finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}
		return listofproperty;
	}
	
	public static int setBookingDate(final BookPropertyDetail bp) throws DAOAppException//Book date
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;

		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();

			final ParamMapper INSERTBOOKINGDETAILSMAPPER=new ParamMapper()
			{	

				@Override
				public void mapParams(PreparedStatement preStmt) throws SQLException {
					preStmt.setInt(1, bp.getPropertyid());
					preStmt.setString(2, bp.getEmail());
					preStmt.setString(3,bp.getDate());
				}

			};

			result=DBHelper.executeUpdate(con,SQLMapper.INSERTBOOKPROPERTYDETAIL,INSERTBOOKINGDETAILSMAPPER);

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
