/**
 * 
 */
package com.dash.util;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

/**
 * @author PraveenKumar
 * Project : Environment_Dashboard_V0.1
 * Version : 0.1
 * Package : com.dash.util
 * Date    : 2018, Jul 21, 2018, 12:09:49 PM
 * User    : PraveenKumar
 * Tags    : 
 * Description :
 *		
 */
public class DBUtil {

	static Connection con=null;
	
	public static Connection getDBConnection(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/environment_dashboard", "eclipse","eclipse");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	/*public static void main(String args[]){
		for(int i=0;i<10000;i++){
		Connection conn=DBUtil.getDBConnection();
		
		Statement stmt=null;
		String query="select * from dash_board_ais_config";
		try {
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()){
				System.out.println(rs.getString("environment"));
				System.out.println(rs.getString("inst"));
				System.out.println(rs.getString("url"));
				System.out.println(rs.getString("machine_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	}*/
}
