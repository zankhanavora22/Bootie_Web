package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.wishlist;

public class WishlistDao {
	public static void insertWishLIst(wishlist w) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="insert into wishlist(cusid,pid) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, w.getCusid());
			pst.setInt(2, w.getPid());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<wishlist> getWishListByCusId(int id){
		List<wishlist> list = new ArrayList<wishlist>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from wishlist where cusid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				wishlist w = new wishlist();
				w.setWid(rs.getInt("wid"));
				w.setCusid(rs.getInt("cusid"));
				w.setPid(rs.getInt("pid"));
				list.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
