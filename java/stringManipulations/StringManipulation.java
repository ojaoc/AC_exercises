// print the following message at the end
// I am a Code Cadet at < Academia de Codigo_ >, www.academiadecodigo.org

public class StringManipulation {

    public static void main(String[] args) {
        
        String str = "http://www.academiadecodigo.org";
        manipulate(str);

    }

    private static void manipulate(String str) {
        
        String domain; // www.academiadecodigo.org
        String name; // < Academia de Codigo_ >

        domain = str.replaceAll("(http):/*", "");
        // name = str

    }

}