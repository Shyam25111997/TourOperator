package com.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.training.entity.SignUpDetails;
import com.training.ifaces.Dao;





public class SignUpDetailsDao implements Dao<SignUpDetails>{

private Connection con;
	
	public SignUpDetailsDao(Connection con) {
		super();
		this.con=con;
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public int add(SignUpDetails t) throws SQLException {
		 String sql = "insert into TravelAgency values(?,?,?,?,?)";
         
         PreparedStatement pstmt =con.prepareStatement(sql);
    
        // here 1 denotes the sql argument ? and NoT column number in table 
                
        pstmt.setString(1, t.getFirstName());
        pstmt.setString(2, t.getLastName());
        pstmt.setString(3, t.getUserType());
        pstmt.setInt(4, t.getId());
        pstmt.setString(5, t.getPassword());
        
       
        int rowAdded = pstmt.executeUpdate();
        
        return rowAdded;
	}
	
	
	private SignUpDetails mapToSignUpDetails(ResultSet resultSet) throws SQLException {
        
        
          String firstName = resultSet.getString("firstName");
	      String lastName = resultSet.getString("lastName");
	      String userType = resultSet.getString("userType");
	      int id = resultSet.getInt("id");
	      String password = resultSet.getString("password");
       
         SignUpDetails pmt = new SignUpDetails(firstName,lastName,userType,id,password);
         return pmt;
}
	
	private String searchByKey = "select * from TravelAgency where id=? and password=?";
    
    @Override
    public SignUpDetails findById(int id, String password) throws SQLException {
           
    PreparedStatement pstmt = con.prepareStatement(searchByKey);
    SignUpDetails pmt =null;
    pstmt.setInt(1,id);
    pstmt.setString(2, password);
    ResultSet resultSet = pstmt.executeQuery();
      if(resultSet.next()) {
             pmt = mapToSignUpDetails(resultSet);
    	  System.out.println("Id found");
      }
           
    else
    {
    	System.out.println("Id or password mismatch");
    }
      return pmt;
    }

}
