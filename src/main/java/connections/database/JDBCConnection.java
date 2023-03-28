package connections.database;

import java.sql.*;

public class JDBCConnection {
	
	private String host = "localhost";
	private String port = "3306";
	private Connection connection;
	private Statement statement;
	private static ResultSet result1;
	private ResultSet result2;
	
	String email = null;
	String password = null;
	String pname = null;
	String country = null;
	
	public Statement jdbcConnection() throws Exception
	{
		
		//url="jdbc:mysql://"+host+":"+port+":"+"/databasename";
		connection = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/QADBTest", "root", "Agnivo@200123");
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		return statement;
		
	}
	
	/*public Object[][]  getRusult1() throws Exception
	{
			JDBCConnection test = new JDBCConnection();
		//Statement statement = ((Connection) test).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		Statement statement = test.jdbcConnection();
		result1 = statement.executeQuery("select * from testdata where email='agnivo.test@yopmail.com'");
		
		int colCount = result1.getMetaData().getColumnCount();
		result1.last();
		int rowCount = result1.getRow();
		result1.beforeFirst();
		
		Object[][] data = new Object[rowCount][colCount];
		 int row = 0;
		    while (result1.next()) {
		        for (int i = 0; i < colCount; i++) {
		            data[row][i] = result1.getObject(i+1);
		            //System.out.print( result1.getObject(i+1)+" ");
		        }
		        row++;
		        //System.out.println();
		    }
		
		return data;
		
	}*/
	
	public Object[][] getResult2() throws Exception
	{
			JDBCConnection test = new JDBCConnection();
			//Statement statement = ((Connection) test).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			Statement statement = test.jdbcConnection();
			result2 = statement.executeQuery("select * from testdata");
			
			int colCount = result2.getMetaData().getColumnCount();
			result2.last();
			int rowCount = result2.getRow();
			result2.beforeFirst();
			
			Object[][] data = new Object[rowCount][colCount];
			 int row = 0;
			    while (result2.next()) {
			        for (int i = 0; i < colCount; i++) {
			            data[row][i] = result2.getObject(i+1);
			            //System.out.print( result1.getObject(i+1)+" ");
			        }
			        row++;
			        //System.out.println();
			    }
			
			return data;

	}

}
