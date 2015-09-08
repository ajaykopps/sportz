/**
 * 
 */
package com.sportz.dao.interfaces;

import java.sql.*;
import java.util.List;

/**
 * @author koppar
 *
 */
public interface IDataAccess {
	
	int fireInsertQuery(String insertQuery, List<String> insertParams);
	int fireUpdateQuery(String updateQuery, List<String> updateParams);
	int fireDeleteQuery(String deleteQuery, List<String> deleteParams);
	ResultSet fireSelectQuery(String selectQuery,List<String> queryParams);

}
