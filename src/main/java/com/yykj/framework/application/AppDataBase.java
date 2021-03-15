package com.yykj.framework.application;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yykj.framework.bean.Student;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

/**
 * 数据库连接
 */
public class AppDataBase {

	/**
	 *
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws Exception {

		// TODO: 1.JDBC连接DB
		//jdbcConnection();

		// TODO: 2.JDBC连接DB insert & select
		//jdbcConnection02();

		// TODO: 3.DBUtils 连接池
		//dbUtils();

		// TODO: 4.C3P0
		//c3P0Test();

		// TODO: 5.DBCP
		dbcpTest();
	}

	/**
	 * JDBC链接数据库
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private static void jdbcConnection() throws ClassNotFoundException, SQLException {
		
		String driver = "com.mysql.cj.jdbc.Driver"; 
		String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC"; 
		String userName = "root";
		String password = "hh96n55g";
		
		Class.forName(driver);
		
		String sql = "select * from student;";
		Connection conn = DriverManager.getConnection(url, userName, password);
		Statement statement = conn.createStatement();
		ResultSet res = statement.executeQuery(sql);
		while(res.next()){
			int code = res.getInt("code");
			String name = res.getString("name");
			int age = res.getInt("age");
			
			System.out.println("code:" + code + " name:" + name + " age:" + age);
		}
	}

	/**
	 * JDBC
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void jdbcConnection02() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
		String userName = "root";
		String password = "hh96n55g";

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, userName, password);
//		conn.setAutoCommit(false);
//		conn.rollback();
//		conn.commit();

		String sql = "insert into student(name,age) values('张三',100);";
		Statement stat = conn.createStatement();
		int num = stat.executeUpdate(sql);
		System.out.println("1.执行数据：" + num);

		sql = "select * from student";
		stat = conn.createStatement();
		ResultSet res = stat.executeQuery(sql);
		while (res.next()) {
			int code = res.getInt(1);
			String name = res.getString(2);
			int age = res.getInt(3);
			System.out.println("编码：" + code + " 姓名：" + name + "  年龄：" + age);
		}

		res.close();
		stat.close();
		conn.close();
	}

	/**
	 * DBUtils
	 * @throws Exception
	 */
	public static void dbUtils() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
		String userName = "root";
		String password = "hh96n55g";

		ComboPooledDataSource source = new ComboPooledDataSource();
		source.setDriverClass(driver);
		source.setJdbcUrl(url);
		source.setUser(userName);
		source.setPassword(password);

		QueryRunner runner = new QueryRunner(source);
		ResultSetHandler<List<Student>> rsh = new BeanListHandler<>(Student.class);
		List<Student> stuList = runner.query("select * from student", rsh);
		for(Student info: stuList){
			System.out.println(info.getName() + " " + info.getAge());
		}

//		QueryRunner runner = new QueryRunner(source);
//		ResultSetHandler<List<Student>> rsh = new BeanListHandler<Student>(Student.class);
//		List<Student> students = runner.query("select * from student;", rsh);
//		System.out.println(students);
//
//		MapListHandler msh = new MapListHandler();
//		List<Map<String, Object>> maps = runner.query("select * from student;", msh);
//		System.out.println(maps);
	}

	/**
	 * C3P0
	 * @throws Exception
	 */
	public static void c3P0Test() throws Exception{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
		String userName = "root";
		String password = "hh96n55g";

		ComboPooledDataSource source = new ComboPooledDataSource();
		source.setDriverClass(driver);
		source.setJdbcUrl(url);
		source.setUser(userName);
		source.setPassword(password);

		Connection conn = source.getConnection();
		Statement stat = conn.createStatement();
		ResultSet set = stat.executeQuery("select * from student;");
		int cols = set.getMetaData().getColumnCount();
		System.out.println("111");
		while(set.next()){
			for(int i = 1; i <= cols; i++){
				System.out.println("\t" + set.getString(i).toString());
			}
		}
	}

	/**
	 * DBCP
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public static void dbcpTest() throws  Exception{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
		String userName = "root";
		String password = "hh96n55g";

		@SuppressWarnings("resource")
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(driver);
		source.setUrl(url);
		source.setUsername(userName);
		source.setPassword(password);

		Connection conn = source.getConnection();
		Statement stat = conn.createStatement();
		ResultSet set = stat.executeQuery("select * from student;");
		int cols = set.getMetaData().getColumnCount();
		System.out.println("111");
		while(set.next()){
			for(int i = 1; i <= cols; i++){
				System.out.println("\t" + set.getString(i).toString());
			}
		}
	}
}
