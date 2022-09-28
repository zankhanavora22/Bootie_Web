package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnection;
import model.Customer;
import model.Seller;


public class CustomerDao {
	public static void insertCustomer(Customer c) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into customer1(name,contact,address,email,password) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, c.getName());
			pst.setLong(2, c.getMobile_no());
			pst.setString(3, c.getAddress());
			pst.setString(4, c.getEmail());
			pst.setString(5, c.getPassword());
			pst.executeUpdate();
			System.out.println("Registration Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static Customer loginCustomer(Customer c) {
		Customer c1 = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from customer1 where email=? and password=? ";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, c.getEmail());
			pst.setString(2, c.getPassword());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				c1 = new Customer();
				c1.setId(rs.getInt("id"));
				c1.setName(rs.getString("name"));
				c1.setMobile_no(rs.getLong("contact"));
				c1.setAddress(rs.getString("address"));
				c1.setEmail(rs.getString("email"));
				c1.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c1;
		
	}
	public static void updateCustomer(Customer c) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update customer1 set name=?,contact=?,address=?,email=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, c.getName());
			pst.setLong(2, c.getMobile_no());
			pst.setString(3, c.getAddress());
			pst.setString(4, c.getEmail());
			pst.setInt(5, c.getId());
			pst.executeUpdate();
			System.out.println("data updated");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkPassword(String email,String pass) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from customer1 where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static void updatePassword(String email,String np) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="update customer1 set password=? where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("pass updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
