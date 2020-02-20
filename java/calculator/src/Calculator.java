public class Calculator {

    public String brand;
    public String color;

    public Calculator(String brand, String color) {

        System.out.println("I\'m a " + brand + " calculator!");

        this.brand = brand;
        this.color = color;

    }

    public int add(int number1, int number2) {

        return number1 + number2;

    }

    public float add(float number1, float number2) {

        return number1 + number2;

    }

    public float add(int number1, float number2) {

        return number1 + number2;

    }


}
