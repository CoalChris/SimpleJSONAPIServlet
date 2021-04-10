package process;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;


public class ProcessApplication {
	
	private static float factor = 1;
	
	public static float calculateServiceability(String jsonBlob) {
		
		float result = 0;
		
		try {
			JSONObject jsonObject =  new JSONObject(jsonBlob);
	        
			float totalMonthlyIncome = 0;
	        JSONArray income = jsonObject.getJSONArray("income");
	        for (int i = 0; i < income.length(); i++) {
	        	JSONObject obj = income.getJSONObject(i);
	        	float value = obj.getFloat("value");
	        	String frequency = obj.getString("frequency");
	        	// get monthly value
	            if (frequency.equalsIgnoreCase("day")) {
	            	value = value * 30;
	            } else if (frequency.equalsIgnoreCase("week")) {
	            	value = value / 7 * 30;
	            } else if (frequency.equalsIgnoreCase("year")) {
	            	value = value / 12;
	            }
	            totalMonthlyIncome += value;
	        }
	        
	        float totalMonthlyExpenses = 0;
	        JSONArray expenses = jsonObject.getJSONArray("expenses");
	        for (int i = 0; i < expenses.length(); i++) {
	        	float value = Float.parseFloat(expenses.getString(i));
	        	totalMonthlyExpenses += value;
	        }
	        
	        float surplus = totalMonthlyIncome - totalMonthlyExpenses;
	        
	        result = surplus * factor;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Logger logger = Logger.getLogger("Application Process Log");
    	String logFileName = "applicationProcess_"+System.currentTimeMillis()+".log";
        FileHandler fh;
		try {
			fh = new FileHandler(logFileName);
			logger.addHandler(fh);
	        logger.info("JSON Data: " + jsonBlob);
	        fh.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return result;
	}
	
	public static float processApplicationFile(String fileName) {
		float result = 0;
		
		try {     
        	String text = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
        	
        	result = calculateServiceability(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return result;
	}
}
