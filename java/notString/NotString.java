// Given a string, print a new string where "not " has been added to the front. However, if the string already begins with "not", 
// print the string unchanged.  

public class NotString {
	
	public static void main(String[] args) {

    	notString("semicolon");
    	notString("not semicolon");

    	//receive command line argument if available
    	if (args.length > 0) {
      		
			notString(args[0]);
    	
		}

	}

	private static void notString(String str) {
		
		String firstThreeCh = str.substring(0, 3);

		if (firstThreeCh.equals("not")) {

			System.out.println(str);

		} else {

			System.out.println("not " + str);

		}	

	}

}
