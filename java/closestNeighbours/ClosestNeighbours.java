// Find the two neighbouring numbers in an array with the smallest difference to each other

public class ClosestNeighbours {

    public static void main(String[] args) {

        int[] myArray = {0, 5, 1209, 6, 2, 111, 112, 33};

        int[] result = findClosest(myArray);

        System.out.println("Here are the neighbours: " + result[0] + " and " + result[1]);
    }
    
    private static int[] findClosest(int[] numbers) {

        int smallestDif = Math.abs(numbers[1] - numbers[0]);

        int index = 0;

        for (int i = 1; i < numbers.length; i++) {

            int currentDif = Math.abs(numbers[i] - numbers[i - 1]);

            if (smallestDif > currentDif) {

                smallestDif = currentDif;

                index = i;

            }

        }

        return new int[] {numbers[index - 1], numbers[index]};

    }

}