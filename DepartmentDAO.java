import java.sql.*;

public class DepartmentDAO implements DepartmentDAOI{

	private User extractUserFromResultSet(ResultSet rs) throws SQLException {
 	 Department dept = new Department();
   	 dept.setDeptId( rs.getInt("deptId") );
   	 dept.setDeptName( rs.getString("deptName") );
   	 dept.setCreatedDateTime( rs.getDate("createdDateTime") );
   	 dept.setUpdatedDateTime( rs.getDate("updatedDateTime") );
   	 dept.setCreatedId( rs.getInt("createdId") );
   	 dept.setUpdatedId(rs.getInt("updatedId"));
   	 
   	 return dept;
	}

	public User getDepartment(int id) {
    Connection connection = connectionFactory.getConnection();
    try {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Department WHERE deptId=" + id);
        if(rs.next())
        {
            return extractUserFromResultSet(rs);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return null;
}
public Set getAllDepartments() {
    Connector connector = new Connector();
    Connection connection = connector.getConnection();
    try {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Department");
        Set depts = new HashSet();
        while(rs.next())
        {
            Department dept = extractUserFromResultSet(rs);
            depts.add(dept);
        }
        return depts;
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return null;
}
public boolean insertDepartment(Department dept) {
    Connector connector = new Connector();
    Connection connection = connector.getConnection();
    try {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO Department VALUES (NULL, ?, ?, ?,?,?)");
        ps.setString(1, dept.getDeptName());
        ps.setDate(2,dept.getCreatedDateTime);
        ps.setDate(3, dept.getUpdatedDateTime);
        ps.setInt(4, dept.getCreatedId);
        ps.setInt(5,dept.getUpdatedId);
        
        int i = ps.executeUpdate();
      if(i == 1) {
        return true;
      }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}
public boolean updateUser(Department dept) {
    Connector connector = new Connector();
    Connection connection = connector.getConnection();
    try {
        PreparedStatement ps = connection.prepareStatement("UPDATE Department SET deptName=?, createdDateTime=?,updatedDateTime=?, createdId=?,updatedId=? WHERE deptId=?");
          ps.setString(1, dept.getDeptName());
        ps.setDate(2,dept.getCreatedDateTime);
        ps.setDate(3, dept.getUpdatedDateTime);
        ps.setInt(4, dept.getCreatedId);
        ps.setInt(5,dept.getUpdatedId);
        ps.setInt(5,dept.getDeptId);
        int i = ps.executeUpdate();
      if(i == 1) {
    return true;
      }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}
public boolean deleteUser(int id) {
    Connector connector = new Connector();
    Connection connection = connector.getConnection();
    try {
        Statement stmt = connection.createStatement();
        int i = stmt.executeUpdate("DELETE FROM Department WHERE deptId=" + id);
      if(i == 1) {
    return true;
      }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}

}