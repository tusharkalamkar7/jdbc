package com.project.dao;
import java.sql.*;
public class EmployeeDAO implements EmployeeDAOInterface{
	public void save(int empNo, String name, double sal, int dNo)throws Exception{
		//Here we want to insert the given Employee details to the DB
		//To do thid we need to execute the following sql statement to DB
		String sql = "insert into emp values("+empNo+", '"+name+"',"+sal+","+dNo+")";
		Connection con = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(con!=null)
					con.close();
			}catch(Exception e){}
		}
	}

	public boolean updateSal(int empNo, double newSal)throws Exception{
		String sql = "update emp set sal=sal+"+newSal+" where empno="+empNo;
		Connection con = null;
		boolean flag = false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			Statement st = con.createStatement();
			if(st.executeUpdate(sql)>0){
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(con!=null)
					con.close();
			}catch(Exception e){}
		}
		return flag;
	}
	public String getEmp(int empNo)throws Exception{
		String sql = "select * from emp where empno="+empNo;
		StringBuilder sb = new StringBuilder();
		Connection con = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				sb.append(rs.getInt(1));
				sb.append("t");
				sb.append(rs.getString(2));
				sb.append("t");
				sb.append(rs.getDouble(3));
				sb.append("t");
				sb.append(rs.getInt(4));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(con!=null)
					con.close();
			}catch(Exception e){}
		}
		return sb.toString();
	}

	public boolean delete(int empno) throws Exception{
		String sql = "delete from emp where empno="+empno;
		Connection con = null;
		boolean flag = false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			Statement st = con.createStatement();
			if(st.executeUpdate(sql)>0){
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(con!=null)
					con.close();
			}catch(Exception e){}
		}
		return flag;
	}
}