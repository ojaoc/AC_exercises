import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        User freshMeat = new User();

        System.out.println("Please create your new account.");

        System.out.println("Insert username:");

        freshMeat.userName = in.nextLine();

        System.out.println("Welcome, " + freshMeat.userName + "! Tell me your first name");

        String first = in.nextLine();

        freshMeat.setFirstName(first);

        System.out.println("Ok, Now your family name!");

        String last = in.nextLine();

        freshMeat.setLastName(last);

        System.out.println("Now we need a password.");

        String pass = in.nextLine();

        freshMeat.setPass(pass);

        System.out.println("Thanks for registering, " + freshMeat.getFullName() + "!");

    }

}
