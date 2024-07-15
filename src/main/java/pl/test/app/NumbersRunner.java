package pl.test.app;

import pl.test.services.NumbersService;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumbersRunner {

    public static void main(String[] args) {
        NumbersService numbersService = new NumbersService();

        int[] sequence1 = {1,2,3,4,5};
        int[] sequence2 = {5,6,4123,8,9,7};
        int[] sequence3 = {2,4,8,16,32};

        System.out.println(numbersService.isArithmetic(sequence1));
        System.out.println(numbersService.isArithmetic(sequence2));
        System.out.println(numbersService.isArithmetic(sequence3));

        System.out.println("*****************************************");
        /////////////////////////////////////////////////////////////
        // zad2

        System.out.println(numbersService.getSequenceName(sequence1));
        System.out.println(numbersService.getSequenceName(sequence2));
        System.out.println(numbersService.getSequenceName(sequence3));

        System.out.println("*****************************************");
        /////////////////////////////////////////////////////////////
        // zad3

        int from = 1;
        int to = 100;
        int[] superPrimes = numbersService.isSuperPrimes(from, to);

        System.out.println("Liczby super-pierwsze z zakresu od " + from + " do " + to);
        for (int prime : superPrimes) {
            System.out.print(prime + " ");
        }


        System.out.println("\n*****************************************");

        //zad 4

        File file = new File("liczby.txt");

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] numbersAsString = line.split(" ");

                int[] sequence = new int[numbersAsString.length];

                for (int i = 0; i < numbersAsString.length; i++) {
                    sequence[i] = Integer.parseInt(numbersAsString[i]);
                }

                numbersService.getReport(sequence);
                System.out.println("*****************************************");
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Nie znaleziono pliku." + e.getMessage());
        }
    }
}
