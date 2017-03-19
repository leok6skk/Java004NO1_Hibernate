package _01_ProductTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAO {

	Context ctx;
	DataSource ds;

	public ProductDAO() {

		try {
			ctx = new InitialContext();
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		try {
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Java004NO1");
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
	}

	synchronized public String insert(ProductBean pb, InputStream is, long size) {

		String sql = "INSERT INTO Product " + " VALUES(? ,?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, pb.getProductId());
			pstmt.setInt(2, pb.getPgPrice());
			pstmt.setString(3, pb.getName());
			pstmt.setDouble(4, pb.getAvgCost());
			pstmt.setString(5, pb.getOplace());
			pstmt.setInt(6, pb.getSlife());
			pstmt.setString(7, pb.getSuppierId());
			pstmt.setString(8, pb.getFileName());
			pstmt.setBinaryStream(9, is, size);
			pstmt.executeUpdate();

			System.out.println("成功 新增" + pb.getProductId());

			return null;
		} catch (Exception e) {
			System.out.println("儲存資料" + pb.getProductId() + "時發生錯誤，請檢查，例外=" + e.getMessage());
			e.printStackTrace();
			return "儲存資料" + pb.getProductId() + "時發生錯誤，請檢查，例外=" + e.getMessage();
		}
	}

	public boolean delete(String productId) {

		String sql = "DELETE FROM Product WHERE Product_id =? ;";
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, productId);
			pstmt.executeUpdate();
			System.out.println("成功 刪除 " + productId);
			return true;
		} catch (SQLException e) {
			System.out.println("失敗 刪除 " + productId);
			e.printStackTrace();
			return false;
		}
	}

	synchronized public String update(ProductBean pb) {

		String sql = "UPDATE Product SET " + " p_g_price = ?, name = ?, "
				+ " avg_cost = ?, o_place = ?, s_life = ?, suppier_id = ?" + " WHERE product_id = ?;";

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, pb.getPgPrice());
			pstmt.setString(2, pb.getName());
			pstmt.setDouble(3, pb.getAvgCost());
			pstmt.setString(4, pb.getOplace());
			pstmt.setInt(5, pb.getSlife());
			pstmt.setString(6, pb.getSuppierId());
			pstmt.setString(7, pb.getProductId());
			pstmt.executeUpdate();

			System.out.println("成功修改" + pb.getProductId());

			return "成功修改" + pb.getProductId();
		} catch (SQLException e) {
			System.out.println("儲存資料" + pb.getProductId() + "時發生錯誤，請檢查，例外=" + e.getMessage());
			e.printStackTrace();
			return "儲存資料" + pb.getProductId() + "時發生錯誤，請檢查，例外=" + e.getMessage();
		}
	}

	// public String findByPrimaryKey(String productId){
	//
	// String sql = "select * from Product where Product_id =?;";
	// String Product_id = null;
	//
	// try(
	// Connection con = ds.getConnection();
	// PreparedStatement pstmt = con.prepareStatement(sql);){
	//
	// pstmt.setString(1, productId);
	// try(
	// ResultSet rs = pstmt.executeQuery();
	// ){
	// if (rs.next()){
	// Product_id = rs.getString(1);
	// }
	// }
	// return Product_id;
	// }catch (Exception e){
	//
	// e.printStackTrace();
	// }
	// return null;
	// }

	public List<ProductBean> findByPrimaryKey(String productId) {

		String sql = "select * from Product where product_id = ?;";

		List<ProductBean> coll = new ArrayList<>();
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, productId);

			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					ProductBean pb = new ProductBean();
					pb.setProductId(rs.getString(1));
					pb.setPgPrice(rs.getInt(2));
					pb.setName(rs.getString(3));
					pb.setAvgCost(rs.getDouble(4));
					pb.setOplace(rs.getString(5));
					pb.setSlife(rs.getInt(6));
					pb.setSuppierId(rs.getString(7));
					pb.setFileName(rs.getString(8));

					coll.add(pb);
					Iterator<ProductBean> it = coll.iterator();
					while (it.hasNext()) {
						Object o = it.next();
						System.out.println(o);
					}
				}
				System.out.println("序號查詢資料");
			}
			return coll;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public List<ProductBean> findByName(String productName) {

		String sql = "select * from Product where product_id like '%?%';";
		System.out.println(sql);
		List<ProductBean> coll = new ArrayList<>();
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, productName);

			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					ProductBean pb = new ProductBean();
					pb.setProductId(rs.getString(1));
					pb.setPgPrice(rs.getInt(2));
					pb.setName(rs.getString(3));
					pb.setAvgCost(rs.getDouble(4));
					pb.setOplace(rs.getString(5));
					pb.setSlife(rs.getInt(6));
					pb.setSuppierId(rs.getString(7));
					pb.setFileName(rs.getString(8));

					coll.add(pb);
				}
				System.out.println("品名查詢資料");
			}
			return coll;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public List<ProductBean> findAll() {

		String sql = "select * from Product;";

		List<ProductBean> coll = new ArrayList<>();
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					ProductBean pb = new ProductBean();
					pb.setProductId(rs.getString(1));
					pb.setPgPrice(rs.getInt(2));
					pb.setName(rs.getString(3));
					pb.setAvgCost(rs.getDouble(4));
					pb.setOplace(rs.getString(5));
					pb.setSlife(rs.getInt(6));
					pb.setSuppierId(rs.getString(7));
					pb.setFileName(rs.getString(8));
					coll.add(pb);
				}
				System.out.println("記錄 查詢all");
			}
			return coll;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean ifExist(String productId) {

		String sql = "select * from product where product_id =?;";
		try (Connection con = ds.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(sql);
			) {

			pstmt.setString(1, productId);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public byte[] getImage(String productId) {

		String sql = "select productImage from Product where product_id =?;";

		try (Connection con = ds.getConnection(); 
			 PreparedStatement pstmt = con.prepareStatement(sql);
			){
			pstmt.setString(1, productId);
			try (ResultSet rs = pstmt.executeQuery();) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				InputStream is = null;
				
				while (rs.next()) {
		
					is = rs.getBinaryStream(1);
					byte buffer[] = new byte[8192];
					int len = 0;
					while ((len = is.read(buffer)) != -1) {
						baos.write(buffer, 0, len);
					}				 
					return baos.toByteArray();
				}
				System.out.println("讀取圖片成功");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public byte[] getAllImage() {

		String sql = "select productImage from Product;";

		try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
			){
			
			try (ResultSet rs = pstmt.executeQuery();) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				InputStream is = null;
				
				while (rs.next()) {
		
					is = rs.getBinaryStream(1);
					byte buffer[] = new byte[8192];
					int len = 0;
					while ((len = is.read(buffer)) != -1) {
						baos.write(buffer, 0, len);
					}				 
					return baos.toByteArray();
				}
				System.out.println("讀取圖片成功");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
