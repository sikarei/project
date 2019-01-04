package take;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TakeDB {
	 private Connection conn;
	    private static final String USERNAME = "counter";
	    private static final String PASSWORD = "12345";
	    private static final String URL = "jdbc:mysql://localhost/count?useUnicode=true&characterEncoding=euckr";
	    private PreparedStatement pstmt, pstmt1, pstmt2 = null;
	    private Statement stmt, stmt1 = null;
	    private ResultSet rs, rs2;
	    
		public TakeDB() {
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				System.out.println("���� ����!!");
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("���� ����!!");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Ŭ���� ���� ����!!");
			}
		}

		public void ReSetNum(int no){
			String sql = "Update kitchen set no = no -1 where no > ?";
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		public void UpdateSetting(String s) { //orders ���̺� no �����ϰ� ����
			String sql1 = "set @count = 0;";
			String sql2 = "update "+s+" set no = @count:=@count+1;";
			try {
				pstmt=conn.prepareStatement(sql1);
				pstmt1=conn.prepareStatement(sql2);
				pstmt.executeQuery();
				pstmt1.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		public void SelNo(int no){
			String sql = "select no from kitchen where ordernum = ?";
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();
				if(rs.next()){
					Takefood.no = rs.getInt("no");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		public void ordercancel(int no) {
			String sql = "delete from kitchen where ordernum = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}				
		}
		public void orderfinish(int no) {
			String sql = "delete from finish where ordernum = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
}
