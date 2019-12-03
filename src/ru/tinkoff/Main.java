package ru.tinkoff;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Inspector isModToFifteen = (int x) -> x % 15 == 0;

        Inspector isPositive = (int x) -> x > 0;

        Inspector isNotFibonacci = (int x) -> {
            int fib1 = 0;
            int fib2 = 1;
            do {
                int saveFib1 = fib1;
                fib1 = fib2;
                fib2 = saveFib1 + fib2;
            }
            while (fib2 < x);
            return fib2 == x;
        };

        String input = "";

        System.out.println("Type 'exit' if you want to close program");

        Scanner reader = new Scanner(System.in);

        whileLoop: while (true) {
            System.out.println("Enter an Integer number");
            input = reader.nextLine();

            if( input.equals("exit")) {
                System.out.println("closing...");
                break;
            }

            int checked;
            try {
                checked = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("you should input an Integer!");
                continue whileLoop;
            }
            System.out.println("Is number is divided by 15 without a remainder: " + isModToFifteen.check(checked));
            System.out.println("Is number positive: " + isPositive.check(checked));
            System.out.println("Is number not one of Fibonacci numbers: " + isNotFibonacci.check(checked));
        }
        reader.close();
    }
}
