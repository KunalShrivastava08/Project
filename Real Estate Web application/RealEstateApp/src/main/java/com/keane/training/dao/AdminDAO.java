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
import com.keane.training.domain.PropertyDetails;

public class AdminDAO 
{

	public static List getAllPropertry() throws DAOAppException  {
		List allproperty=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			allproperty=DBHelper.executeSelect(con,SQLMapper.FETCHALLPROPERTYDETAILS,SQLMapper.ALLPROPERTYMAPPER);
					
		} catch (DBConnectionException e) {
			System.out.println(e);
		
		} catch (DBFWException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
				
				System.out.println(e);
			}
		}
		
		
		return allproperty;
	}

	public static int validity(PropertyDetails pd) throws DAOAppException {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;

		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();

			final ParamMapper UPDATEVALIDITYMAPPER=new ParamMapper()
			{	

				@Override
				public void mapParams(PreparedStatement preStmt) throws SQLException {
					preStmt.setString(1, pd.getValidity());
					preStmt.setInt(2, pd.getPropertyid());
					
				}

			};

			result=DBHelper.executeUpdate(con,SQLMapper.UPDATEVALIDITY,UPDATEVALIDITYMAPPER);
		} catch (DBFWException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (DBConnectionException e) {
			e.printStackTrace();
			System.out.println(e);
		}

		return result;
	}

	public static int deleteBookProperty(PropertyDetails pd) throws DAOAppException
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result= 0;

		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();

			final ParamMapper DELETEPROPERTYMAPPER=new ParamMapper()
			{	

				@Override
				public void mapParams(PreparedStatement preStmt) throws SQLException {
					preStmt.setInt(1,pd.getPropertyid());
					
				}
			};

			result=DBHelper.executeUpdate(con,SQLMapper.DELETEBOOKPROPERTYDETAIL,DELETEPROPERTYMAPPER);


		} catch (DBFWException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (DBConnectionException e) {
			e.printStackTrace();
			System.out.println(e);
		}

		return result;
	}
	
	public static int deleteProperty(final PropertyDetails pd) throws DAOAppException
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result= 0;

		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();

			final ParamMapper DELETEPROPERTYMAPPER=new ParamMapper()
			{	

				@Override
				public void mapParams(PreparedStatement preStmt) throws SQLException {
					preStmt.setInt(1,pd.getPropertyid());
					
				}
			};

			result=DBHelper.executeUpdate(con,SQLMapper.DELETEPROPERTYDETAIL,DELETEPROPERTYMAPPER);


		} catch (DBFWException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (DBConnectionException e) {
			e.printStackTrace();
			System.out.println(e);
		}

		return result;
	}

}
