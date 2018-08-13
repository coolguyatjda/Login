package com.jda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jda.model.UserModel;

public class DatabaseUtil {
	private static String jdbcUrl = "jdbc:mysql://" + System.getenv("DBHOST") + ":3306/" + System.getenv("DBNAME")
			+ "?user=" + System.getenv("DBUSER") + "&password=" + System.getenv("DBPASSWORD");

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcUrl);
		return connection;
	}

	public static void addData(UserModel user) {
		try {
			Connection connection = getConnection();
			PreparedStatement pst = connection.prepareStatement("insert into data values(?, ?, ?, ?)");
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getPhoneNumber());
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static UserModel fetchData(String email, String password) {
		UserModel user = new UserModel();
		try {
			Connection connection = getConnection();
			String query = "select * from data where email='" + email + "' and password='" + password + "';";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (!rs.next()) {
				return null;
			} else {
				user.setName(rs.getString("name"));
				user.setEmail(email);
				user.setPassword(password);
				user.setPhoneNumber(rs.getString("phoneNumber"));
				return user;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
