public class Main {

    public static void main(String[] args) {

        Calculator casio = new Calculator("Casio", "Grey");

        int result = casio.add(3, 4);

        System.out.println(result);

        float resultFloat = casio.add(2.5f, 2.5f);

        System.out.println(resultFloat);

        float resultIntFloat = casio.add(2, 3.2f);

        System.out.println(resultIntFloat);

        Calculator noBrand = new Calculator("No Brand", "Black");

        int badResult = noBrand.add(5, 5);

        System.out.println(badResult);

    }

}

