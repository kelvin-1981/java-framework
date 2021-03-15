package com.yykj.framework.application;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yykj.framework.bean.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

/**
 * 数据库连接
 */
public class AppDataBase02 {

	public static void main(String[] args) throws Exception {

		// 查询数据
		// jdbcSelect();

		// 添加数据
		// jdbcInsert();

		// 修改数据
		// jdbcUpdate();

		// 删除数据
		// jdbcDelete();

		// 批处理
		//batchInsert();

		//C3P0数据库连接池，可配置文件
		//C3P0Select();

		//查询结果转换为类对象
		dBUtils();
	}

	/**
	 * 查询结果转换为类对象
	 */
	private static void dBUtils() throws Exception{
		// TODO Auto-generated method stub
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
		String user = "root";
		String password = "P@ssw0rd";

		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(driver);
		dataSource.setJdbcUrl(url);
		dataSource.setUser(user);
		dataSource.setPassword(password);

		QueryRunner runner = new QueryRunner(dataSource);
		BeanListHandler<Student> rsh = new BeanListHandler<Student>(Student.class);
		List<Student> students = runner.query("select * from student;", rsh);
		dataSource.close();

		for (Student info: students) {
			System.out.println("name:" + info.getName());
		}
	}

	/**
	 * C3P0Select
	 */
	private static void C3P0Select() throws Exception{
		// TODO Auto-generated method stub
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
		String user = "root";
		String password = "P@ssw0rd";

		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(driver);
		dataSource.setJdbcUrl(url);
		dataSource.setUser(user);
		dataSource.setPassword(password);

		Connection conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from student where name = ?");
		ps.setString(1, "kelvin");
		ResultSet resultSet = ps.executeQuery();

		while (resultSet.next()) {
			int code = resultSet.getInt("code");
			String name = resultSet.getString("name");
			int age = resultSet.getInt("age");
			System.out.println("code:" + code + " name:" + name + " age:" + age);
		}

		ps.close();
		conn.close();
	}

	/**
	 * 批处理
	 */
	private static void batchInsert() throws Exception{
		// TODO Auto-generated method stub

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
		String user = "root";
		String password = "P@ssw0rd";

		Class.forName(driver);

		String sql = "insert into student(name,age) values(?,?)";
		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement ps = conn.prepareStatement(sql);

		for(int i = 0; i < 10; i++){
			ps.setString(1, "ken");
			ps.setInt(2, 100);

			ps.addBatch();
		}

		int[] executeBatch = ps.executeBatch();

		ps.close();
		conn.close();

		System.out.println(executeBatch.length > 0 ? "Success" : "Fail");
	}

	/**
	 * 删除数据
	 */
	private static void jdbcDelete() throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
		String user = "root";
		String password = "hh96n55g";

		Class.forName(driver);

		String sql = "delete from student where name = ?;";
		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "ken");
		int num = ps.executeUpdate();

		System.out.println(num > 0 ? "Success" : "Fail");
	}

	/**
	 * 修改数据
	 */
	private static void jdbcUpdate() throws Exception {
		// TODO Auto-generated method stub
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
		String user = "root";
		String password = "hh96n55g";

		Class.forName(driver);

		String sql = "update student set age = ? where name = ?;";
		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 0);
		ps.setString(2, "ken");
		int num = ps.executeUpdate();

		System.out.println(num > 0 ? "Success" : "Fail");
	}

	/**
	 * @throws SQLException
	 *
	 */
	@SuppressWarnings("unused")
	private static void jdbcInsert() throws Exception {
		// TODO Auto-generated method stub
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
		String user = "root";
		String password = "hh96n55g";

		Class.forName(driver);

		String sql = "insert into student(name,age) values(?,?)";
		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "ken");
		ps.setInt(2, 100);
		int num = ps.executeUpdate();

		ps.close();
		conn.close();

		System.out.println(num > 0 ? "Success" : "Fail");
	}

	/**
	 * 查询数据
	 *
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static void jdbcSelect() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
		String user = "root";
		String password = "hh96n55g";

		Class.forName(driver);

		String sql = "select * from student";
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		conn.close();
		while (resultSet.next()) {
			int code = resultSet.getInt("code");
			String name = resultSet.getString("name");
			int age = resultSet.getInt("age");
			System.out.println("code:" + code + " name:" + name + " age:" + age);
		}
	}
}
