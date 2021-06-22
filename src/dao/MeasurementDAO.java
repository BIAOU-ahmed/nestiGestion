/**
 * 
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
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

	// INSERT INTO `product` (`idProduct`, `productName`) VALUES (NULL,
	// 'testProduct');

	@Override
	public Measurement getFromResultSet(ResultSet rs) throws SQLException {
		Measurement result = null;

		if (rs != null && !rs.isClosed() && rs.next()) {

			result = new Measurement();
			result.setId(rs.getInt("idMeasurement"));
			result.setUnit(rs.getString("unit"));

		}

		return result;
	}

	/**
	 * this function take the object Measurement in parameter and insert it in the
	 * database
	 * 
	 * @param unit the object Measurement
	 * @throws SQLException all SQL Exceptions
	 */
	public void insert(Measurement unit) throws SQLException {
		var sql = "INSERT INTO " + getTableName()
				+ "(`unit`)"
				+ " VALUES (?);";

		var insertArticle = DBConnection.get().prepareStatement(sql);

		insertArticle.setString(1, unit.getUnit());

		insertArticle.executeUpdate();

	}

	/**
	 * this function update the Measurement pass in parameter in the database
	 * @param Measurement the object article
	 * @throws SQLException all SQL Exception
	 */
	public void update(Measurement unit) throws SQLException {
		String sql = "UPDATE " + getTableName()
				+ " SET unit = ? WHERE idMeasurement  = ?;";

		var updateUser = DBConnection.get().prepareStatement(sql);
		updateUser.setString(1, unit.getUnit());
		updateUser.setInt(2, unit.getId());

		updateUser.executeUpdate();

	}
	


}
