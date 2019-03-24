package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDataTable {
	private UserInfo userInfo;
	private static final String URL = "jdbc:mysql://localhost:3306/sys?useSSL=false&serverTimezone=UTC";
	private static final String USER_MYSQL = "root";
	private static final String PASSWORD_MYSQL = "marina";
	private static final String REQUEST_GET_LOGIN_PASSWORD = "SELECT login, password FROM test_automation.USERS";

	public UserDataTable() {
		userInfo = new UserInfo();
	}

	public void setUserLoginPasswordFromDB() {
		try (Connection con = DriverManager.getConnection(URL, USER_MYSQL, PASSWORD_MYSQL);
				Statement statement = con.createStatement();
				ResultSet resultset = statement.executeQuery(REQUEST_GET_LOGIN_PASSWORD)) {
			if (resultset.next()) {
				userInfo.setLogin(resultset.getString(1));
				userInfo.setPassword(resultset.getString(2));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public String getUserLogin() {
		return userInfo.getLogin();
	}

	public String getUserPassword() {
		return userInfo.getPassword();
	}
}