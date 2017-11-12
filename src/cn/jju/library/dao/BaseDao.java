package cn.jju.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	
	protected Connection conn = null;// 数据链接对象
	protected Statement st = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshop",
					"root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;// 返回链接duix

	}

	public int exceuteUpdate(String sql, Object... param) {
		// PreparedStatement pstmt = null;
		int result = 0;
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				pstmt.setObject(i + 1, param[i]);
				}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);

		}
		return result;
	}
	
	
	public int exceuteInsert(String sql, Object[] parameters) {
		int result = 0;
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			if(parameters != null) {
				for(int i = 0; i < parameters.length; i++){
				pstmt.setObject(i + 1, parameters[i]);
				}
			}
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
				result =rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);

		}
		return result;
	}
	

	public ResultSet exceuteQuery(String prepareSql, Object[] param) {
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(prepareSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);//ΪԤ����sql���ò���
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 //closeAll(conn,pstmt,null);//!!!!
		}
		return rs;
	}
	
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}