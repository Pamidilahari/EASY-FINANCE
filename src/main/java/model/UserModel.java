package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import beans.UserBean;


public class UserModel {
  
  public static long nextPk() {
    long pk = 0;
    Connection conn;
    try {
    	String url="jdbc:mysql://localhost:3306/javawebapp";
        String username="root";
        String password="Lahari@15";
      conn = DriverManager.getConnection(url,username,password);
      PreparedStatement stmt = conn.prepareStatement("select Max(id) from user");
      ResultSet rs = stmt.executeQuery();
      while(rs.next()){
        pk = rs.getLong(1);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return pk+1;
    
  }
  
  
  public static long addUser(UserBean user) {
    int i = 0;
    try {
    	String url="jdbc:mysql://localhost:3306/javawebapp";
        String username="root";
        String password="Lahari@15";
      Connection conn = DriverManager.getConnection(url,username,password);
      PreparedStatement stmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
      stmt.setLong(1, nextPk());
      stmt.setString(2 , user.getFirstName() );
      stmt.setString(3 , user.getLastName() );
      stmt.setString(4 , user.getLogin() );
      stmt.setString(5 , user.getPassword() );
      stmt.setDate(6 , new java.sql.Date(user.getDob().getTime()) );
      stmt.setString(7 , user.getMobileNo() );
        i =     stmt.executeUpdate();
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    return i;
  }
  public static UserBean  UserLogin(String login,String Password) {
	    Connection con;
	    UserBean user = null;
	    try {
	    	String url="jdbc:mysql://localhost:3306/javawebapp";
	        String username="root";
	        String password="Lahari@15";
	      Connection conn = DriverManager.getConnection(url,username,password);
	      PreparedStatement stmt = conn.prepareStatement("Select * from user where login=? and password = ?");
	      stmt.setString(1,login);
	      stmt.setString(2,Password);
	      ResultSet rs = stmt.executeQuery();
	      if(rs.next()) {
	        user = new UserBean();
	        System.out.println("ID: "+rs.getLong("id"));
	        user.setId(rs.getLong("id"));
	        user.setFirstName(rs.getString("fname"));
	        user.setLastName(rs.getString("lname"));
	        user.setLogin(rs.getString("login"));
	        user.setPassword(rs.getString("password"));
	        user.setDob(rs.getDate("dob"));
	        user.setMobileNo(rs.getString("mobile"));    
	      }
	      
	    } catch (Exception e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
	    return user;
	  }
}


