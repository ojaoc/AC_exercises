package org.academiadecodigo.ramsters.scumLambda;

public class Main {

    public static void main(String[] args) {

        Machine<Integer> machineInteger = new Machine<>();

        Machine<String> machineString = new Machine<>();




        Integer sum = machineInteger.singleOperand(100, i1 -> i1 + i1);

        Integer adding = machineInteger.singleOperand(10, i2 -> i2 + 5);

        String concatenated = machineString.singleOperand("Pum", s1 -> s1 + s1);

        String concatenated2 = machineString.singleOperand("Batata", s2 -> s2 + " Doce");

        Integer maxBitch = machineInteger.dualOperand(1, 1000, Integer::max);

        String concatenateTwoStrings = machineString.dualOperand("Fabinh", " Bigodjinh", String::concat);




        System.out.println(sum);

        System.out.println(adding);

        System.out.println(concatenated);

        System.out.println(concatenated2);

        System.out.println(maxBitch);

        System.out.println(concatenateTwoStrings);

    }

}
