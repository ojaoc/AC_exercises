// Given a non-empty string and an int n, print a new string where the char at index n has been removed.                                
// Dúvidas:
// 1º- O que significa aquele if statement dentro da main() function

public class MissingChar {
	
	public static void main(String[] args) {
	
		missingChar("Robocop", 3);
		
  		//receive command line argument if available
  		if (args.length >= 2) {
    	
			missingChar(args[0], Integer.parseInt(args[1]));
	
		}

	}

	private static void missingChar(String str, int n) {
		
		String strNew = str.substring(0, n) + str.substring(n + 1);
		System.out.println(strNew);	

	}

}
