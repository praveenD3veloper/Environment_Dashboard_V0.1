/**
 * 
 */
package com.dash.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.json.simple.JSONObject;

import com.dash.bean.AIS_Bean;

/**
 * @author PraveenKumar
 * Project : Environment_Dashboard_V0.1
 * Version : 0.1
 * Package : com.dash.service
 * Date    : 2018, Jul 21, 2018, 5:30:26 PM
 * User    : PraveenKumar
 * Tags    : 
 * Description :
 *		This project is developed for the purpose of Artificial Intelligence based Home Automation 
 * 	on the raspberry pi 3 B+ platform.
 */
public class ResponseFetchAdministrator {
	JSONObject json=null;
	
	public JSONObject getAllResponse(){
		//first check ais responses
		return getAllAisResponse();
		//then check all cfs response
		
		//then check all rcm response
	}
	
	//dummy method to check the data in map
	public void mapdatacheck(){
		System.out.println("insidedatacheck");
		Map <String, ArrayList<String>> map=AIS_Bean.map;
		//traversing through the created map
				Set <String> keys=map.keySet();
				for(String key : keys){
					int size=map.get(key).size();
					System.out.println("Environment "+key);
					System.out.println("size :"+size);
					for(int i=0;i<size;i++){
						System.out.println("output: "+map.get(key).get(i));
					}
				}
	}
	
	public void setJson(String env, int size, int count){
		System.out.println("Received env "+env+" size "+size+" and their status counts "+count);
		Map <String, String> map=AIS_Bean.outmap;
		String respcolor="";
		if (count==0){
			respcolor="R";
		}
		else if(count==size){
			respcolor="G";
		}
		else {
			respcolor="A";
		}
		map.put(env, respcolor);
		json.put(env, respcolor);
	}
	//this method will return all ais response by connecting to heartbeat url's
	public JSONObject getAllAisResponse(){
		json=new JSONObject();
		int count=0;
		//mapdatacheck();
		System.out.println("insidegetaisallresponse");
		Map <String, ArrayList<String>> map=AIS_Bean.map;
		//traversing through the created map
				Set <String> keys=map.keySet();
				for(String key : keys){
					String current_env=key;
					int size=map.get(key).size();
					System.out.println("Environment "+key);
					System.out.println("size :"+size);
					count=0;
					for(int i=0;i<size;i++){
						String current_url=map.get(key).get(i).toString();
						System.out.println("output: "+current_url);
						URL url;
						try {
							String arr[]=current_url.split(",");
							url = new URL(arr[1]);
							URLConnection ec=url.openConnection();
							BufferedReader in=new BufferedReader(new InputStreamReader(ec.getInputStream(), "UTF-8"));
							String inLine=in.readLine();
							if(inLine.equalsIgnoreCase("Server Up"))
								count++;
							else
								System.out.println("Invalid Response Received from "+arr[1]+"...!");
							System.out.println("Response for url"+inLine);
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					setJson(current_env, size, count);
				}
		return json;
	}
}
