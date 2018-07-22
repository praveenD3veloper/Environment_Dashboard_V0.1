/**
 * 
 */
package com.dash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dash.bean.AIS_Bean;
import com.dash.util.DBUtil;

/**
 * @author PraveenKumar
 * Project : Environment_Dashboard_V0.1
 * Version : 0.1
 * Package : com.dash.dao
 * Date    : 2018, Jul 21, 2018, 11:59:47 AM
 * User    : PraveenKumar
 * Tags    : 
 * Description :
 *		
 */
public class ConfigFetchDAO {
	Connection con=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public boolean allConfigFetch(){
		boolean status=true;
		//AIS_Bean ais_bean=new AIS_Bean();
		String current_env="";
		ArrayList <String> list=null;
		con=DBUtil.getDBConnection();
		try {
			pstmt=con.prepareStatement("select distinct environment from dash_board_ais_config order by environment");
			rs=pstmt.executeQuery();
			while(rs.next()){
				current_env=rs.getString("environment");
				System.out.println("Retrieved Environment :"+current_env);
				PreparedStatement pstmt2=con.prepareStatement("select * from dash_board_ais_config where environment like ? order by inst");
				pstmt2.setString(1, current_env+"%");
				ResultSet rs2=pstmt2.executeQuery();
				list=new ArrayList<String>();
				while(rs2.next()){
					String inst=rs2.getString("inst");
					String url=rs2.getString("url");
					System.out.println("Retrieved instance and url "+inst+","+url);
					list.add(inst+","+url);
					AIS_Bean.map.put(current_env, list);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			status=false;
		}
		return status;
	}
}
