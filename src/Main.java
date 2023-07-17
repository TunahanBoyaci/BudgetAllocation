import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much can you spend?");

        double total = scanner.nextDouble();
        double sum = 0;
        int i = 0;

        ArrayList<Double> proportion = new ArrayList<>();
        System.out.println("Enter your proportion of various expenses.");
        System.out.println("The system stops if cumulative proportion exceeds %100");

        do {
            System.out.println("Your proportion of expense " + (i + 1) + ": ");
            double value = scanner.nextDouble();
            proportion.add(value);
            sum += proportion.get(i);
            i++;
        } while (sum <= 100);

        scanner.close();

        if (sum > 100){
            double cumulativeSum = 0.0;
            for (int j = 0; j < proportion.size(); j++) {
                cumulativeSum += proportion.get(j);
            }
            proportion.set(proportion.size() - 1, 100.0 - cumulativeSum);

            for (double value : proportion){
                double expense = value * total / 100.0;
                System.out.println("Your " + value + "% equals $" + expense);
            }
        }
    }
}