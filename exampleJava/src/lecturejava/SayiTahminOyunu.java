package lecturejava;

import java.util.Scanner;

public class SayiTahminOyunu {

    public static void main(String[] args) {

        System.out.println("---Welcome to Number Finding Game---");

        String text = "Play: 1 "
                + "Quit: 2";
        System.out.println(text);
        System.out.println("--------------------------------");

        boolean value = true;
        Scanner input = new Scanner(System.in);

        while (value) {

            System.out.print("Your choice: ");
            int choice = input.nextInt();

            int random = (int) (Math.random() * 1000) + 1;
            int num;

            switch (choice) {
                case 1:
                    System.out.println("Please enter a valid number 1-1000 for find the number!");

                    while (true) {
                        System.out.print("Number: ");
                        num = input.nextInt();

                        if (num > 0) {

                            int[] random_array = numbersDigit(random);
                            int[] num_array = numbersDigit(num);
                            boolean[] visited_array = new boolean[random_array.length];

                            for (int i = 0; i < num_array.length; i++) {
                                for (int j = 0; j < random_array.length; j++) {
                                    if (!visited_array[j] && num_array[i] == random_array[j]) {
                                        System.out.println(num_array[i] + " is correct...");
                                        visited_array[j] = true;
                                        break;
                                    }
                                }
                            }

                            if (num == random) {
                                System.out.println("Correct guess!");
                                break;
                            } else {
                                System.out.println("Try again!");
                            }

                        }else{
                            System.out.println("Please enter valid number!");
                        }

                    }
                    break;

                case 2:
                    System.out.println("The program is being terminated...");
                    value = false;
                    break;
                default:
                    System.out.println("Please choose valid option!");
                    break;
            }

        }

    }

    public static int digitFind(int number) {
        int digit = 0;

        do {

            number /= 10;
            digit++;

        } while (number > 0);

        return digit;
    }

    public static int[] numbersDigit(int num) {
        int constant = digitFind(num);
        int[] array = new int[constant];
        for (int i = 0; i < constant; i++) {
            array[i] = num % 10;
            num /= 10;
        }
        return array;
    }
}
