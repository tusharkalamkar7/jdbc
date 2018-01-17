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

	public User getAddress(int id) {
    Connection connection = connectionFactory.getConnection();
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
    Connector connector = new Connector();
    Connection connection = connector.getConnection();
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
    Connector connector = new Connector();
    Connection connection = connector.getConnection();
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
    Connector connector = new Connector();
    Connection connection = connector.getConnection();
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
    Connector connector = new Connector();
    Connection connection = connector.getConnection();
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