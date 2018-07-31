/**
 * @author: PraveenKumar 
 * @source: service.js
 */
var req;
function initialLoad(){
	if(window.XMLHttpRequest){
		console.log("Obtained xmlhttprequest");
		req=new XMLHttpRequest;
	}
	else if (window.ActiveXObject){
		console.log("Obtained activexobject");
		req=new ActiveXObject("Microsoft.XMLHTTP");
	}
	else{
		console.log("Browser doesn't support Ajax");
		window.alert("No Ajax support for the browser..!")
	}
	req.onreadystatechange=getAllesponse;
	req.open('GET',"./fetchresponse?q=all",true);
	req.send();
}

//function to get all response 
function getAllResponse(req){
	if (req.status==200 && req.readyState==4){
		console.log("Servlet is ready to server request...!");
		console.log("Response from servlet for object "+req+req.responseText.toString);
		var json=JSON.parse(req.responseText);
		console.log(json);
		var x;
		for(x in json){
			console.log("took the key: "+x);
			console.log(json[x]);
			if (json[x]=="R"){
				console.log("coloring "+x+"as"+json[x]);
				document.getElementById(x).style.backgroundColor="red";
			}if (json[x]=="G"){
				console.log("coloring "+x+"as"+json[x]);
				document.getElementById(x).style.backgroundColor="green";
		}
			if (json[x]=="A"){
				console.log("coloring "+x+"as"+json[x]);
				document.getElementById(x).style.backgroundColor="#ff9933";
		}
			}
	}
}

//function to get response from requseted component
function getResponse(){
	if(req.status==200 && req.readyState==4){
		console.log("Servlet is ready to serve request...!");
		console.log("response"+req.responseText.toString());
		var json=JSON.parse(req.responseText);
		console.log(json);
		var x;
		for(x in json){
			console.log("took the key: "+x);
			console.log(json[x]);
			if (json[x]=="R"){
				console.log("coloring "+x+"as"+json[x]);
				document.getElementById(x).style.backgroundColor="red";
			}if (json[x]=="G"){
				console.log("coloring "+x+"as"+json[x]);
				document.getElementById(x).style.backgroundColor="green";
		}
			if (json[x]=="A"){
				console.log("coloring "+x+"as"+json[x]);
				document.getElementById(x).style.backgroundColor="#ff9933";
		}
			}
}

function render(){
	initialLoad();
}