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
	
	private static void createTable() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String createTableSQL = "CREATE TABLE Department ("
				+"deptId NUMBER NOT NULL AUTO_INCREMENT,"
				+"deptName varchar(30),"
				+"createdDateTime date,"
				+"updatedDateTime date,"
				+"createdId NUMBER,"
				+"updatedId NUMBER,"
				+"PRIMARY KEY (deptId)"
				+")";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(createTableSQL);

			System.out.println(createTableSQL);

			// execute create SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Table Department is created!");

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

public User getDepartment(int id) {
    Connection connection = ConnectionFactory.getConnection();
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
    Connection connection = ConnectionFactory.getConnection();
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
    Connection connection = ConnectionFactory.getConnection();
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
    Connection connection = ConnectionFactory.getConnection();
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
    Connection connection = ConnectionFactory.getConnection();
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
