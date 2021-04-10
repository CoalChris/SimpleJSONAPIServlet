import process.ProcessApplication;


public class Main {

	public static void main(String[] args) {
		
		if (args.length > 0) {
			String fileName = args[0];
			
			float serviceability = ProcessApplication.processApplicationFile(fileName);
            System.out.println("Serviceability: " + serviceability);
		} else {
			System.out.println("No JSON file path provided.");
		}
	}

}
