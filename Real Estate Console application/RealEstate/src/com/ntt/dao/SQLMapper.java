package com.ntt.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ntt.dbfw.ResultMapper;
import com.ntt.domain.PropertyDetails;
import com.ntt.domain.UserDetails;

public class SQLMapper 
{
	public static final String FETCHAVAILABLEPROPERTY="select * from PropertyDetails8039 where location8039=? AND type8039=? AND amount8039<=? AND availability8039 ='yes'"; //use select all Property Details from PropertyDetails8039;
	public static final String INSERTBOOKPROPERTYDETAIL="insert into BookPropertyDetails8039  values(?,?,?)";//use to insert data in BookPropertyDetails8039 table
	public static final String UPDATEAVAILABILITY="update PropertyDetails8039 set availability8039=? where propertyid8039=?"; // select Property Details from country_081;
	public static final String DELETEBOOKPROPERTYDETAIL="delete from BookPropertyDetails8039 where PropertyID8039=?";//delete property from book property table
	public static final String DELETEPROPERTYDETAIL="delete from PropertyDetails8039 where PropertyID8039=?";//delete property from property table
	public static final String INSERTUSERDETAILS="insert into UserDetails8039 values(?,?,?,?,?)";//insert data in user table
	public static final String FETCHUSERIDPASS="select ROLEID8039 from UserDetails8039 where (email8039=? and PASSWORD8039=?) OR (contactnumber8039=? ANd password8039=?)";//get the role id from the user table
	public static final String FETCHALLPROPERTYDETAILS="Select * from PropertyDetails8039";//get all details from property table
	public static final String INSERTPROPERTYDETAILS="insert into PropertyDetails8039 (location8039,type8039,amount8039,availability8039,EMAIL8039) values(?,?,?,?,?)";//insert property details in property table
	public static final String UPDATEVALIDITY="update PropertyDetails8039 set  VALIDATE8039=? where PropertyID8039=?";//Update the validity
	public static final String FETCHPRICE="Select amount8039 from PropertyDetails8039 where propertyid8039=(SELECT propertyid8039 from BookPropertyDetails8039 where EMAIL8039 =?) ";//get all details from property table
	public static final String FETCHUSERPROPERTY="Select * from PropertyDetails8039 where email8039=?";
	
	public static final ResultMapper ALLPROPERTYMAPPER=
			new ResultMapper() {
		@Override
		public Object mapRow(ResultSet rs) throws SQLException {
			int propertyid=rs.getInt(1);
			String location=rs.getString(2);
			String type=rs.getString(3);
			long price=rs.getLong(4);
			String available=rs.getString(5);
			String email=rs.getString(6);
			String validity=rs.getString(7);
			PropertyDetails pd=new PropertyDetails(propertyid, location, type, price, available,email,validity);
			return pd;
		}//mapRow
	};//Anonymous class use
	
	public static final ResultMapper USERDETAILSMAPPER=
			new ResultMapper()
	{
		@Override
		public Object mapRow(ResultSet rs) throws SQLException {
			int roleid=rs.getInt(1);
			UserDetails ud=new UserDetails(roleid);
			return ud;
		}//mapRow

	};//Anonymous class
	
	

	public static final ResultMapper GETPRICEMAPPER=
			new ResultMapper()
	{
		@Override
		public Object mapRow(ResultSet rs) throws SQLException {
			long price=rs.getLong(1);
			PropertyDetails pd=new PropertyDetails(price);
			return pd;
		}//mapRow

	};//Anonymous class
	
}	
	
	
	

	

