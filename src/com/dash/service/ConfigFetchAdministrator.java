/**
 * 
 */
package com.dash.service;

import com.dash.dao.ConfigFetchDAO;


/**
 * @author PraveenKumar
 * Project : Environment_Dashboard_V0.1
 * Version : 0.1
 * Package : com.dash.service
 * Date    : 2018, Jul 21, 2018, 1:08:06 PM
 * User    : PraveenKumar
 * Tags    : 
 * Description :
 *	
 **/	
public class ConfigFetchAdministrator {

	//get configuration of all environments  from db 
	public boolean getAllConfig(){
		System.out.println("This action completed with db config fetch");
		return new ConfigFetchDAO().allConfigFetch();
	}
	
}
