import java.sql.*;

public class EmployeeDAO implements EmployeeDAOI{

	private User extractUserFromResultSet(ResultSet rs) throws SQLException {
 	 Employee emp = new Employee();
   	 emp.setEmpId( rs.getInt("empId") );
   	 emp.setFirstName( rs.getString("firstName") );
   	 emp.setLastName( rs.getString("lastName") );
   	 emp.setMobNo( rs.getString("mobNo") );
   	 emp.setDeptId(rs.getInt("deptId"));
   	 emp.setCreatedDateTime(rs.getDate("createdDateTime"));
   	 emp.setUpdatedDateTime(rs.getDate("updatedDateTime"));
   	 emp.setCreatedId(rs.getInt("createdId"));
   	 emp.setUpdatedId(rs.getInt("updatedId"));
   	 return emp;
	}

	public User getEmployee(int id) {
    Connection connection = connectionFactory.getConnection();
    try {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employee WHERE empId=" + id);
        if(rs.next())
        {
            return extractUserFromResultSet(rs);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return null;
}
public Set getAllEmployees() {
    Connector connector = new Connector();
    Connection connection = connector.getConnection();
    try {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");
        Set employees = new HashSet();
        while(rs.next())
        {
            Employee emp = extractUserFromResultSet(rs);
            employees.add(emp);
        }
        return employees;
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return null;
}
public boolean insertEmployee(Employee emp) {
    Connector connector = new Connector();
    Connection connection = connector.getConnection();
    try {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO Employee VALUES (NULL, ?, ?, ?,?,?,?,?,?)");
        ps.setString(1, emp.getFirstName());
        ps.setString(2, emp.getLastName());
        ps.setString(3, emp.getMobNo());
        ps.setInt(4, emp.getDeptId());
        
        ps.setDate(5, emp.getCreatedDateTime());
        ps.setDate(6, emp.getUpdatedDateTime());
        ps.setInt(7, emp.getCreatedId());
        ps.setInt(8, emp.getUpdatedId());
        
        int i = ps.executeUpdate();
      if(i == 1) {
        return true;
      }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}
public boolean updateEmployee(Employee emp) {
    Connector connector = new Connector();
    Connection connection = connector.getConnection();
    try {
        PreparedStatement ps = connection.prepareStatement("UPDATE Employee SET firstName=?, lastName=?, mobNo=?, deptId=?,createdDateTime=?,updatedDateTime=?,createdId=?,updatedId=? WHERE empId=?");
        ps.setString(1, emp.getFirstName());
        ps.setString(2, emp.getLastName());
        ps.setString(3, emp.getMobNo());
        ps.setInt(4, emp.getDeptId());
        
        ps.setDate(5, emp.getCreatedDateTime());
        ps.setDate(6, emp.getUpdatedDateTime());
        ps.setInt(7, emp.getCreatedId());
        ps.setInt(8, emp.getUpdatedId());
        ps.setInt(9, emp.getEmpId());
        int i = ps.executeUpdate();
      if(i == 1) {
    return true;
      }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}
public boolean deleteEmployee(int id) {
    Connector connector = new Connector();
    Connection connection = connector.getConnection();
    try {
        Statement stmt = connection.createStatement();
        int i = stmt.executeUpdate("DELETE FROM Employee WHERE empId=" + id);
      if(i == 1) {
    return true;
      }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}

}