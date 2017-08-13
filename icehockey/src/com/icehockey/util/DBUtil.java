package com.icehockey.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
//import org.apache.tomcat.jdbc.pool.DataSource;
import javax.sql.DataSource;

public class DBUtil {
	// 定义静态变量
	static Context envContext = null;
	static DataSource ds = null;
	static String driver = null;
	static String url = null;
	static String username = null;
	static String password = null;

	// 打开Mysql数据库连接，优先使用连接池
	public Connection openConnection() {

		Connection connect = null;
		// 优先读取连接池配置，建立数据库连接池
		if (ds == null) {
			if (envContext == null) {
				try {
					Context initContext = new InitialContext();
					envContext = (Context) initContext.lookup("java:/comp/env");
					System.out.println("Found envContext('java:/comp/env') !");
				} catch (Exception e) {
					System.out
							.println("Error lookup envContext('java:/comp/env') !");
					e.printStackTrace();
				}
			}
			if (envContext != null) {
				try {
					ds = (DataSource) envContext.lookup("jdbc/Mysql_DBCP");
					System.out.println("Found DataSource('jdbc/Mysql_DBCP') !");
				} catch (Exception e) {
					System.out
							.println("Error lookup DataSource('jdbc/Mysql_DBCP') !");
					e.printStackTrace();
				}
			}
		}
		if (ds != null) {
			try {
				connect = ds.getConnection();
				System.out
						.println("Success connect Mysql server (MySQL_DBCP) !");
			} catch (Exception e) {
				System.out.println("error connect Mysql server(DBCP) !");
				e.printStackTrace();
			}
		}
		// 读取配置文件建立数据库连接
		if (connect == null) {
			if (driver == null) {
				Properties properties = new Properties();
				try {
					properties.load(this.getClass().getClassLoader()
							.getResourceAsStream("DBConfig.properties"));
					driver = properties.getProperty("driver");
					url = properties.getProperty("url");
					username = properties.getProperty("username");
					password = properties.getProperty("password");
				} catch (Exception e) {
					System.out.println("Error get Property !");
					e.printStackTrace();
				}
			}
			if (driver != null) {
				try {
					Class.forName(driver);
					connect = DriverManager.getConnection(url, username,
							password);

				} catch (Exception e) {
					System.out.println("Error connect Mysql server !");
					e.printStackTrace();
				}
			}
		}
		return connect;
	}

	/*
	 * //打开Mysql连接池连接 public Connection openMysql_DBCP(){
	 * 
	 * Connection connect=null; try{ Context initContext = new InitialContext();
	 * Context envContext = (Context)initContext.lookup("java:/comp/env");
	 * System.out.println("Found envContext('java:/comp/env')!"); DataSource ds
	 * = (DataSource)envContext.lookup("jdbc/Mysql_DBCP");
	 * System.out.println("Found DataSource('jdbc/Mysql_DBCP') !");
	 * connect=ds.getConnection();
	 * System.out.println("Success connect Mysql server (MySQL_DBCP) !"); }
	 * catch (Exception e) {
	 * System.out.println("error connect Mysql server(DBCP) !");
	 * e.printStackTrace(); } return connect; }
	 */
	// 打开Oracle连接池连接
	public Connection openOrcl_DBCP() {

		Connection connect = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			System.out.println("Found envContext('java:/comp/env')!");
			DataSource ds = (DataSource) envContext.lookup("jdbc/Orcl_DBCP");
			System.out.println("Found DataSource('jdbc/Orcl_DBCP') !");
			connect = ds.getConnection();
			System.out.println("Success connect Oracle server (Orcl_DBCP) !");
		} catch (Exception e) {
			System.out.println("error connect Oracle server(Orcl_DBCP) !");
			e.printStackTrace();
		}
		return connect;
	}

}
