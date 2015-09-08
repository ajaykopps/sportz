/**
 * 
 */
package com.sportz.dao.implementation;

import java.sql.Connection;

import com.sportz.dao.interfaces.IDataConnection;

/**
 * @author koppar
 *
 */
public class DataConnectionImpl implements IDataConnection {

	/* (non-Javadoc)
	 * @see com.sportz.dao.interfaces.IDataConnection#getConnection()
	 */
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sportz.dao.interfaces.IDataConnection#closeConnection()
	 */
	@Override
	public Connection closeConnection(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}

}
