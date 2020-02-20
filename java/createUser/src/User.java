public class User {

    public String userName;

    private String firstName;

    private String lastName;

    private String password;

    public String getFullName() {

        return this.firstName + " " + this.lastName;

    }

    public String setFirstName(String newFirst) {

        return this.firstName = newFirst;

    }

    public String setLastName(String newLast) {

        return this.lastName = newLast;

    }

    public String setPass(String newPass) {

        System.out.println("Your password has been changed.");

        return this.password = newPass;

    }

}
