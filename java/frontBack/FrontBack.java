// Given a string, print a new string where the first and last characters have been exchanged.

public class FrontBack {

	public static void main(String[] args) {

        frontBack("heisenberg");

        //receive command line argument if available
        if (args.length > 0) {
            
            frontBack(args[0]);
        
        }
	
	}

	private static void frontBack(String str) {

        String firstCh = String.valueOf(str.charAt(0));
        String lastCh = String.valueOf(str.charAt(str.length() - 1));
        String middleChs = str.substring(1, str.length() - 1);

        System.out.println(lastCh + middleChs + firstCh);

	}	

}
