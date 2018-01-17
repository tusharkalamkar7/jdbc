	
import java.util.Date;
import java.util.Set;
import java.sql.*;

public class MainDAO {

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
	public Set findByDeptIdAndCity(Integer deptId,String city) {
	    Connection connection = ConnectionFactory.getConnection();
	    try {
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM Employee E "
	        		+ "INNER JOIN Address A ON E.empId = A.empId "
	        		+ "INNER JOIN Department D ON D.deptId = E.deptId "
	        		+ "WHERE D.deptId = "+deptId+" AND A.city = '"+city+"'");
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
	
	public Set findByDeptAndCity(String deptName,String city) {
	    Connection connection = ConnectionFactory.getConnection();
	    try {
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM Employee E "
	        		+ "INNER JOIN Address A ON E.empId = A.empId "
	        		+ "INNER JOIN Department D ON D.deptId = E.deptId "
	        		+ "WHERE D.deptName = '"+deptName+"' AND A.city = '"+city+"'");
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
	
	public Set findByNameAndExpiry(String empName) {
	    Connection connection = ConnectionFactory.getConnection();
	    try {
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM Employee E "
	        		+ "INNER JOIN Address A ON E.empId = A.empId "
	        		+ "INNER JOIN Department D ON D.deptId = E.deptId "
	        		+ "WHERE E.firstname LIKE 'X%' "
	        		+ "AND D.updatedDateTime >= add_months(TRUNC(SYSDATE) + 1, 3)");
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
}