package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.Owner;
import utils.dbutils;

public class Signindao implements Closeable {
	private Connection connection;
	private PreparedStatement signinStatement;
	private PreparedStatement signupStatement;
	private PreparedStatement updateAccountStatement;
	private PreparedStatement updatePasswordStatement;
	private PreparedStatement bookCountStatement;
	
public Signindao() throws Exception 
{
	this.connection = dbutils.getConnection();
	this.signinStatement = connection.prepareStatement("select name, password from users where email=? and password=?");
	this.signupStatement = connection.prepareStatement("insert into users values(?,?,?,?,?,?)");
	this.updateAccountStatement = connection.prepareStatement("update users set email=?, phone=? where password=?");
    this.updatePasswordStatement = connection.prepareStatement("update users set password=? where email=?");
    this.bookCountStatement = connection.prepareStatement("select subject, count(*) from books group by subject");
}

public void signup(Owner owner) throws Exception
{
  this.signupStatement.setInt(1, owner.getId());
  this.signupStatement.setString(2, owner.getName());
  this.signupStatement.setString(3, owner.getEmail());
  this.signupStatement.setString(4, owner.getPhone() );
  this.signupStatement.setString(5, owner.getPasswd());
  this.signupStatement.setString(6, owner.getRole());

  this.signupStatement.executeUpdate();
}


public boolean signin(Owner owner) throws SQLException 
{
	this.signinStatement.setString(1, owner.getEmail());
	this.signinStatement.setString(2, owner.getPasswd());
	try(ResultSet rs = this.signinStatement.executeQuery();) 
	{
	 if(rs.next())
	 {
		 System.out.println("Login succesfully..!!");
		 return true;
	 }
	 else
	 {
		 System.out.println("username or password is incorrect");
		 return false;
	 }
	} 
	catch (SQLException ex) 
	{
		
		ex.printStackTrace();
	}
	return true;
}
public void updateAccount(Owner owner) throws SQLException {
	this.updateAccountStatement.setString(1, owner.getEmail());
	this.updateAccountStatement.setString(2, owner.getPhone());
	this.updateAccountStatement.setString(3, owner.getPasswd());
	
	
	this.updateAccountStatement.executeUpdate();
	
	System.out.println("User updated succesfully...!!");

}

public void updatePassword(Owner owner) throws SQLException {

	this.updatePasswordStatement.setString(1,owner.getPasswd());
	this.updatePasswordStatement.setString(2, owner.getEmail());
	this.updatePasswordStatement.executeUpdate();
}


@Override
public void close() throws IOException 
{
	try {
		this.signinStatement.close();
		this.signupStatement.close();
	    this.connection.close();
	}
	catch (SQLException ex)
	{
		ex.printStackTrace();
	}
}

public void bookCount() throws SQLException {
	
	ResultSet rs = this.bookCountStatement.executeQuery();
	
while(rs.next())
{
	String Subject = rs.getString(1);
	int count = rs.getInt(2);
	System.out.println("subject : " + Subject + ",   " + "Count : "+ count);
}	

}



}
