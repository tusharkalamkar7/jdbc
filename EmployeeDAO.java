import java.sql.*;
import java.util.*;

public class EmployeeDAO implements EmployeeDAOI{

	private Employee extractUserFromResultSet(ResultSet rs) throws SQLException {
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
	
	private static void createTable() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String createTableSQL = "CREATE TABLE Employee ("
					+"empId NUMBER NOT NULL AUTO_INCREMENT,"
					+"firstName varchar(30),"
					+"lastName varchar(30),"
					+"mobNo NUMBER,"
					+"deptId NUMBER,"
					+"createdDateTime date,"
					+"updatedDateTime date,"
					+"createdId NUMBER,"
					+"updatedId NUMBER,"
					+"PRIMARY KEY (empId),"
					+"FOREIGN KEY (deptId) REFERENCES Department(deptId)"
					+")";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(createTableSQL);

			System.out.println(createTableSQL);

			// execute create SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Table Employee is created!");

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

public Employee getEmployee(int id) {
    Connection connection = ConnectionFactory.getConnection();
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
    Connection connection = ConnectionFactory.getConnection();
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
    Connection connection = ConnectionFactory.getConnection();
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
    Connection connection = ConnectionFactory.getConnection();
    try {
        PreparedStatement ps = connection.prepareStatement("UPDATE Employee SET firstName=?, lastName=?, mobNo=?, deptId=?,updatedDateTime=?,createdId=?,updatedId=? WHERE empId=?");
        ps.setString(1, emp.getFirstName());
        ps.setString(2, emp.getLastName());
        ps.setString(3, emp.getMobNo());
        ps.setInt(4, emp.getDeptId());
       
        ps.setDate(5, emp.getUpdatedDateTime());
        ps.setInt(6, emp.getCreatedId());
        ps.setInt(7, emp.getUpdatedId());
        ps.setInt(8, emp.getEmpId());
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
    Connection connection = ConnectionFactory.getConnection();
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
