package pl.test.services;

public class NumbersService {

    public boolean isArithmetic(int[] sequence) {
        if (sequence.length < 2) {
            return true;
        }

        int difference = sequence[1] - sequence[0];

        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] - sequence[i - 1] != difference) {
                return false;
            }
        }

        return true;
    }

    public boolean isGeometric(int[] sequence) {
        if (sequence.length < 2) {
            return true;
        }

        if (sequence[0] == 0) {
            return false;
        }

        double ratio = (double) sequence[1] / sequence[0];

        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i - 1] == 0 || (double) sequence[i] / sequence[i - 1] != ratio) {
                return false;
            }
        }

        return true;
    }

    public String getSequenceName(int[] sequence) {
        if (isArithmetic(sequence)) {
            return "ARYTMETYCZNY";
        } else if (isGeometric(sequence)) {
            return "GEOMETRYCZNY";
        } else {
            return "INNY";
        }
    }

    private boolean isNumberPrime(int number) {
        if (number <= 1 || number % 2 == 0) {
            return false;
        }
        if (number == 2) {
            return true;
        }

        for (int i = 3; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private int isSumOfDigitsPrime(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public int[] isSuperPrimes(int from, int to) {
        int[] superPrimesArray = new int[to - from + 1];
        int count = 0;

        for (int i = from; i <= to; i++) {
            if (isNumberPrime(i) && isNumberPrime(isSumOfDigitsPrime(i))) {
                superPrimesArray[count++] = i;
            }
        }

        int[] result = new int[count];
        for (int j = 0; j < count; j++) {
            result[j] = superPrimesArray[j];
        }
        return result;
    }

    private int getMinNumber(int[] sequence) {
        int min = sequence[0];
        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] < min) {
                min = sequence[i];
            }
        }
        return min;
    }

    private int getMaxNumber(int[] sequence) {
        int max = sequence[0];
        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] > max) {
                max = sequence[i];
            }
        }
        return max;
    }

    private static int getMostFrequent(int[] sequence) {
        int mostFrequent = sequence[0];
        int maxFrequency = 1;

        for (int i = 0; i < sequence.length; i++) {
            int currentNumber = sequence[i];
            int currentFrequency = 1;

            for (int j = i + 1; j < sequence.length; j++) {
                if (sequence[j] == currentNumber) {
                    currentFrequency++;
                }
            }

            if (currentFrequency > maxFrequency) {
                mostFrequent = currentNumber;
                maxFrequency = currentFrequency;
            }
        }

        return mostFrequent;
    }

    private boolean checkIsAllNaturalNumbers(int min, int max, int[] sequence) {
        boolean[] isNumberPresent = new boolean[max - min + 1];

        for (int i = 0; i < sequence.length; i++) {
            int num = sequence[i];
            if (num >= min && num <= max) {
                isNumberPresent[num - min] = true;
            }
        }

        for (int j = 0; j <= max - min; j++) {
            if (!isNumberPresent[j]) {
                return false;
            }
        }

        return true;
    }

    public void getReport(int[] sequence) {
        String type = getSequenceName(sequence);

        int min = getMinNumber(sequence);
        int max = getMaxNumber(sequence);
        int mostFrequent = getMostFrequent(sequence);
        boolean allNaturalNumbersPresent = checkIsAllNaturalNumbers(min, max, sequence);

        System.out.println("Monotonicznosc ciagu: " + type);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Najpopularniejsza liczba: " + mostFrequent);
        System.out.println("Czy między min a max znajduja sie wszystkie mozliwe liczby naturalne: " + allNaturalNumbersPresent);
    }

}
