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
import com.keane.training.domain.UserDetails;

public class RegisterDAO 
{

	public int registerUser(UserDetails ud) throws DAOAppException {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();

			final ParamMapper INSERTUSERDETAILS=new ParamMapper()
			{	
			
				@Override
				public void mapParams(PreparedStatement preStmt) throws SQLException {
					preStmt.setInt(1, ud.getRoleid());
					preStmt.setString(2, ud.getName());
					preStmt.setString(3, ud.getEmail());
					preStmt.setString(4, ud.getPassword());
					preStmt.setLong(5, ud.getContactnum());
					
				}

			};

			result=DBHelper.executeUpdate(con,SQLMapper.INSERTUSERDETAILS,INSERTUSERDETAILS);


		} catch (DBFWException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (DBConnectionException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}

		return result;
	}
	
	public boolean validateUser(final String email) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		List users = null;

		ParamMapper paramMapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, email);
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			users = DBHelper.executeSelect(con, SQLMapper.FETCH_USER,
					SQLMapper.USERDETAILSMAPPER,paramMapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}

		return (users != null && users.size() > 0);

	}
}
