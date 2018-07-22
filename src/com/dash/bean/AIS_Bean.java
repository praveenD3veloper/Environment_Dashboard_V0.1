/**
 * 
 */
package com.dash.bean;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author PraveenKumar
 * Project : Environment_Dashboard_V0.1
 * Version : 0.1
 * Package : com.dash.bean
 * Date    : 2018, Jul 21, 2018, 1:18:48 PM
 * User    : PraveenKumar
 * Tags    : 
 * Description :
 *		
 */
public class AIS_Bean {
	private String Environment="";
	private String instance="";
	private String machine_name="";
	private String url="";
	
	//map gets initialized in ConfigFetchDAO initConfigFetch method
	public static Map <String, ArrayList<String>> map=new TreeMap<String, ArrayList<String>>();
	
	//to store the conclusive response of all ais instances into count(count will be mapped to color)
	public static Map <String, String> outmap=new TreeMap<String, String>();
	
	public String getEnvironment() {
		return Environment;
	}
	public void setEnvironment(String environment) {
		Environment = environment;
	}
	public String getInstance() {
		return instance;
	}
	public void setInstance(String instance) {
		this.instance = instance;
	}
	public String getMachine_name() {
		return machine_name;
	}
	public void setMachine_name(String machine_name) {
		this.machine_name = machine_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
