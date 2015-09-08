/**
 * 
 */
package com.sportz.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sportz.dao.interfaces.IDataAccess;
import com.sportz.dao.interfaces.IDataConnection;

/**
 * @author koppar
 *
 */
public class DataAccessImpl implements IDataAccess {

	/* (non-Javadoc)
	 * @see com.sportz.dao.interfaces.IDataAccess#fireInsertQuery(java.lang.String)
	 */
	@Override
	public int fireInsertQuery(String insertQuery, List<String> insertParams) {
		
		return this.fireCUDQuery(insertQuery, insertParams);
	}

	/* (non-Javadoc)
	 * @see com.sportz.dao.interfaces.IDataAccess#fireUpdateQuery(java.lang.String)
	 */
	@Override
	public int fireUpdateQuery(String updateQuery, List<String> updateParams) {
		// TODO Auto-generated method stub
		return this.fireCUDQuery(updateQuery, updateParams);
	}

	/* (non-Javadoc)
	 * @see com.sportz.dao.interfaces.IDataAccess#fireDeleteQuery(java.lang.String)
	 */
	@Override
	public int fireDeleteQuery(String deleteQuery, List<String> deleteParams) {
		return this.fireCUDQuery(deleteQuery, deleteParams);
	}

	/* (non-Javadoc)
	 * @see com.sportz.dao.interfaces.IDataAccess#fireSelectQuery(java.lang.String)
	 */
	@Override
	public ResultSet fireSelectQuery(String selectQuery, List<String> queryParams) {
		
		IDataConnection dataconn = new DataConnectionImpl();
		Connection conn = dataconn.getConnection();
		PreparedStatement stmt =  this.getPreparedStatement(conn, selectQuery);
		if(stmt != null)
		{
			try
			{
				this.fillPreparedStement(stmt, queryParams);
				ResultSet result = stmt.executeQuery();
				stmt.close();
				return result;
			}
			catch (SQLException sqe)
			{
				//NEED TO LOG ERROR
			}
			finally
			{
				dataconn.closeConnection(conn);
			}
		}
		
		return null;
	}
	
	/** ************************PRIVATE FUNCTIONS  *************************/
	
	private PreparedStatement getPreparedStatement(Connection con, String sqlQuery)
	{
		try
		{
			if (con != null)
				return con.prepareStatement(sqlQuery);
			return null;
		}
		catch(SQLException sqe)
		{
			return null;
		}
	}
	

	
	private void fillPreparedStement(PreparedStatement stmt, List<String> queryParams) throws SQLException
	{

		//Fill Parameters
		int len = 0;
		for(Object obj : queryParams.toArray() )
		{
			stmt.setString(len, queryParams.get(len));
			len++;
		}
	}
	
	private int fireCUDQuery(String insertQuery, List<String> queryParams) {
		// TODO Auto-generated method stub
		IDataConnection dataconn = new DataConnectionImpl();
		Connection conn = dataconn.getConnection();
		PreparedStatement stmt =  this.getPreparedStatement(conn, insertQuery);
		if(stmt != null)
		{
			try
			{
				this.fillPreparedStement(stmt, queryParams);
				int result = stmt.executeUpdate();
				stmt.close();
				return result;
			}
			catch (SQLException sqe)
			{
				//NEED TO LOG ERROR
			}
			finally
			{
				dataconn.closeConnection(conn);
			}
			
		}
		return -1;
	}

}
