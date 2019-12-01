package utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class dbutils 
{
	public static Connection getConnection() throws Exception
	{
		Properties p = new Properties();
		p.load(new FileInputStream("config.properties"));
		Class.forName(p.getProperty("DRIVER"));
		return DriverManager.getConnection(p.getProperty("URL"), p.getProperty("USER"), p.getProperty("PASSWORD"));
	}

}
