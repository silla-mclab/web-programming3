package com.wp.goodsmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class GoodsinfoDao {
	protected Connection conn = null;
	
	protected abstract void connectDB() throws SQLException;
	
	protected void disconnectDB() throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}	
	}

	public List<GoodsDO> getGoodsList() throws SQLException {
		ArrayList<GoodsDO> goodsList = null;
		
		connectDB();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from goodsinfo order by code";
			rs = stmt.executeQuery(sql);
			
			if (rs.isBeforeFirst()) {
				goodsList = new ArrayList<GoodsDO>();
				while (rs.next()) {
					GoodsDO goods = new GoodsDO();
					goods.setCode(rs.getString("code"));
					goods.setTitle(rs.getString("title"));
					goods.setWriter(rs.getString("writer"));
					goods.setPrice(rs.getInt("price"));
					goodsList.add(goods);
				}
			}
		} catch(SQLException e) {
			throw e;
		} finally {		
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			disconnectDB();
		}
		
		return goodsList;
	}
	
	public GoodsDO getGoods(String code) throws SQLException {
		GoodsDO goods = null;
		
		connectDB();
		
//		Statement stmt = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
//			stmt = conn.createStatement();
//			String sql = "select * from goodsinfo where code='" + code + "'";
//			rs = stmt.executeQuery(sql);
			
			String sql = "select * from goodsinfo where code=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, code);
			rs = stmt.executeQuery();

			if (rs.next()) {
				goods = new GoodsDO();
				goods.setCode(rs.getString("code"));
				goods.setTitle(rs.getString("title"));
				goods.setWriter(rs.getString("writer"));
				goods.setPrice(rs.getInt("price"));
			}
		} catch(SQLException e) {
			throw e;
		} finally {		
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			disconnectDB();
		}
				
		return goods;
	}
	
	public int insertGoods(GoodsDO goods) throws SQLException {
		connectDB();
		
		int result = 0;
//		Statement stmt = null;
		PreparedStatement stmt = null;
		
		try {
//			stmt = conn.createStatement();			
//			String sql = String.format("insert into goodsinfo(code, title, writer, price) values ('%s', '%s', '%s', %d)",
//							goods.getCode(), goods.getTitle(), goods.getWriter(), goods.getPrice());
//			result = stmt.executeUpdate(sql);		

			String sql = "insert into goodsinfo(code, title, writer, price) values (?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, goods.getCode());
			stmt.setString(2, goods.getTitle());
			stmt.setString(3, goods.getWriter());
			stmt.setInt(4, goods.getPrice());
			result = stmt.executeUpdate();		
		} catch(SQLException e) {
			throw e;
		} finally {
			if (stmt != null) stmt.close();
			disconnectDB();
		}
		
		return result;
	}
	
	public int updateGoods(GoodsDO goods) throws SQLException {
		connectDB();
		
		int result = 0;
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql = String.format("update goodsinfo set title='%s', writer='%s', price=%d where code='%s'",
							goods.getTitle(), goods.getWriter(), goods.getPrice(), goods.getCode());
			result = stmt.executeUpdate(sql);
		} catch(SQLException e) {
			throw e;
		} finally {
			if (stmt != null) stmt.close();
			disconnectDB();
		}
		
		return result;
	}
	
	public int deleteGoods(String code) throws SQLException {
		connectDB();
		
		int result = 0;
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql = String.format("delete from goodsinfo where code='%s'", code);
			result = stmt.executeUpdate(sql);
		} catch(SQLException e) {
			throw e;
		} finally {
			if (stmt != null) stmt.close();
			disconnectDB();
		}
		
		return result;
	}
}
