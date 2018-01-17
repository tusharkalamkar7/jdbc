import java.sql.*;

public class AddressDAO implements AddressDAOI{

	private User extractUserFromResultSet(ResultSet rs) throws SQLException {
 	 Address addr = new Address();
   	 addr.setId( rs.getInt("id") );
   	 addr.setLine1( rs.getString("line1") );
   	 addr.setLine2( rs.getString("line2") );
   	 addr.setCity( rs.getString("city") );
   	 addr.setState(rs.getString("state"));
   	 addr.setPincode(rs.getInt("pincode"));
   	 addr.setCreatedDateTime(rs.getDate("createdDateTime"));
   	 addr.setUpdatedDateTime(rs.getDate("updatedDateTime"));
   	 addr.setCreatedId(rs.getInt("createdId"));
   	 addr.setUpdatedId(rs.getInt("updatedId"));
   	 
   	 return addr;
	}
	
	private static void createTable() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String createTableSQL = "CREATE TABLE Address("
				+"id NUMBER NOT NULL AUTO_INCREMENT,"
				+"empId NUMBER,"
				+"line1 varchar(30),"
				+"line2 varchar(30),"
				+"city varchar(20),"
				+"state varchar(20),"
				+"pincode NUMBER,"
				+"createdDateTime date,"
				+"updatedDateTime date,"
				+"createdId NUMBER,"
				+"updatedId NUMBER,"
				+"PRIMARY KEY (id),"
				+"FOREIGN KEY (empId) REFERENCES Employee(empId)"
				+")";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(createTableSQL);

			System.out.println(createTableSQL);

			// execute create SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Table Address is created!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

public User getAddress(int id) {
    Connection connection = ConnectionFactory.getConnection();
    try {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Address WHERE id=" + id);
        if(rs.next())
        {
            return extractUserFromResultSet(rs);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return null;
}
	
public Set getAllAddresses() {
    Connection connection = ConnectionFactory.getConnection();
    try {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Address");
        Set addrs = new HashSet();
        while(rs.next())
        {
            Address addr = extractUserFromResultSet(rs);
            addrs.add(addr);
        }
        return addrs;
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return null;
}
	
public boolean insertAddress(Address addr) {
    Connection connection = ConnectionFactory.getConnection();
    try {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO Address VALUES (NULL, ?, ?, ?,?,?,?,?,?,?)");
        ps.setString(1, addr.getLine1());
        ps.setString(2, addr.getLine2());
        ps.setString(3, addr.getCity());
        ps.setString(4, addr.getState());
        ps.setInt(5,addr.getPincode());
        ps.setDate(6,addr.getCreatedDateTime());
        ps.setDate(7,addr.getUpdatedDateTime());
        ps.setInt(8,addr.getCreatedId());
        ps.setInt(9,addr.getUpdatedId());
        
        int i = ps.executeUpdate();
      if(i == 1) {
        return true;
      }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}
	
public boolean updateAddress(Address addr) {
    Connection connection = ConnectionFactory.getConnection();
    try {
        PreparedStatement ps = connection.prepareStatement("UPDATE Address SET line1=?, line2=?,city=?,state=?,pincode=?,createdDateTime=?,updatedDateTime=?,createdId=?,updatedId=? WHERE id=?");
        ps.setString(1, addr.getLine1());
        ps.setString(2, addr.getLine2());
        ps.setString(3, addr.getCity());
        ps.setString(4, addr.getState());
        ps.setInt(5,addr.getPincode());
        ps.setDate(6,addr.getCreatedDateTime());
        ps.setDate(7,addr.getUpdatedDateTime());
        ps.setInt(8,addr.getCreatedId());
        ps.setInt(9,addr.getUpdatedId());
        ps.setInt(10,addr.getId());
        int i = ps.executeUpdate();
      if(i == 1) {
    return true;
      }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}
	
public boolean deleteAddress(int id) {
    Connection connection = ConnectionFactory.getConnection();
    try {
        Statement stmt = connection.createStatement();
        int i = stmt.executeUpdate("DELETE FROM Address WHERE id=" + id);
      if(i == 1) {
    return true;
      }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
 }

}
