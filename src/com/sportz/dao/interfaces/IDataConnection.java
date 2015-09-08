/**
 * 
 */
package com.sportz.dao.interfaces;

import java.sql.Connection;

/**
 * @author koppar
 *
 */
public interface IDataConnection {
	
	Connection getConnection();
	Connection closeConnection(Connection con);

}
