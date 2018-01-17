package com.mkyong.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCPreparedStatementCreateExample {


	public static void main(String[] argv) {

		try {

			createTable();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

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

}
