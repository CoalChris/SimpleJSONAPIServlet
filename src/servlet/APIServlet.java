package servlet;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.io.IOUtils;

import process.ProcessApplication;

@SuppressWarnings("serial")
public class APIServlet extends HttpServlet {

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // receive application details in JSON format
		
	    String result = "Error";
	    
	    String jsonBlob = IOUtils.toString(request.getInputStream());
	    if (jsonBlob != null) {
	    	result = "Serviceability: " + ProcessApplication.calculateServiceability(jsonBlob);
	    }
	    
	    // Return the result
	    OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());
	    writer.write(result);
	    writer.flush();
	    writer.close();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		// nothing for get
	}
}
