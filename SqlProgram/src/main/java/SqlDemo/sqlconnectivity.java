package SqlDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	public class sqlconnectivity
	{
			public static void main(String[] args) throws SQLException {
			try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//Registering Driver
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
			Connection conn = null;
			String dbURL = "jdbc:sqlserver://localhost:1433;databasename=Training;encrypt=false";
			String user = "SqlLogin";
			String pass = "SqlLogin";
			conn = DriverManager.getConnection(dbURL, user, pass);//Establishing  Connection
			if (conn != null) {
			Statement st;
			st = conn.createStatement();//Creating Statement
			String query = "update student set name = 'Sharu R' where name ='Sharu Abhi'";
			String query1 = "select * from student";
			int res = st.executeUpdate(query);//Execute statement--when using update,insert commands.. output comes as integer(1)row affected.. so have to store in integer
			if(res>0)
			{
			System.out.println("Updated");
			}
			else
			{
			System.out.println("update unsuccessful");
			}
			ResultSet rs = st.executeQuery(query1);//Execute statement gets data from the table
			while(rs.next()){
			int roll_num=rs.getInt(1);
			String stuname=rs.getString(2);
			String place=rs.getString(3);
			System.out.println(roll_num + " " +stuname+ "        "+place);
			}
			}
			conn.close();
			}
	}