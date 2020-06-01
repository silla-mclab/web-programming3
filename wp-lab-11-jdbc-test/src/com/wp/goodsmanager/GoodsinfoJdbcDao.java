package com.wp.goodsmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoodsinfoJdbcDao extends GoodsinfoDao {
	private String jdbcDriver;
	private String dbUrl;
	private String dbUserId;
	private String dbPasswd;
		
	public GoodsinfoJdbcDao(String jdbcDriver, String dbUrl, String dbUserId, String dbPasswd) {
		this.jdbcDriver = jdbcDriver;
		this.dbUrl = dbUrl;
		this.dbUserId = dbUserId;
		this.dbPasswd = dbPasswd;
	}
	
	protected void connectDB() throws SQLException {
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		conn = DriverManager.getConnection(dbUrl, dbUserId, dbPasswd);
	}
}
