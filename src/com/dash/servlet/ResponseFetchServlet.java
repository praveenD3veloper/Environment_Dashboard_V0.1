package com.dash.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dash.service.ConfigFetchAdministrator;
import com.dash.service.ResponseFetchAdministrator;

/**
 * Servlet implementation class ResponseFetchServlet
 */
public class ResponseFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseFetchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    //initialize all the configurations into ds from db @ the time of starting the application
	public void init(ServletConfig config) throws ServletException {
		//invoke methods related to Fetching config details from db to initialize the beans 
		if(initializeConfig()){
			System.out.println("Successfully Initialized the configurations...!:)");
			//when config fetch completes successfully call fetchallResponse to get status
			if(fetchAllResponse()==null){
				System.out.println("Fetched Response from all machines...! :)");
			}
			else{
				System.out.println("Failed to Fetch Response from all machines, Requested page may not get data...!");
			}
		}
		else{
			System.out.println("Failed to Initialize the configurations...!");
		}
		
	}
	
	//this method will load the ds with all the config from db
	public boolean initializeConfig(){
		return new ConfigFetchAdministrator().getAllConfig(); 
	}
	
	//this method fetches response from all the mapped url's 
	public JSONObject fetchAllResponse(){
		return new ResponseFetchAdministrator().getAllResponse();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet Get method hit...!");
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getParameter("q").equalsIgnoreCase("all"))
		out.println(fetchAllResponse());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
