/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
import tools.DBConnection;

/**
 * @author ahmed
 *
 */
public class MeasurementDAO extends BaseDAO<Measurement> {


	@Override
	public String getTableName() {

		return "measurement";
	}
	
	//INSERT INTO `product` (`idProduct`, `productName`) VALUES (NULL, 'testProduct');
	
	@Override
	 public Measurement getFromResultSet(ResultSet rs) throws SQLException
	    {
		Measurement result = null;

	        if (rs != null && !rs.isClosed() && rs.next()) {
	        	
	        	result = new Measurement();
	        	result.setId(rs.getInt("idMeasurement"));
	        	result.setUnit(rs.getString("unit"));
		        	
	        	
	        }
	        
	        return result;
	    }
	 
}
