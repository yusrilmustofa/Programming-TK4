package TK4;

import java.util.Scanner;



public class no1A {
    public static void main(String[] args) {
        executeActivity(new CarDriving());
        executeActivity(new Biking());
    }

    private static void executeActivity(Biking biking) {
        throw new UnsupportedOperationException("Unimplemented method 'executeActivity'");
    }

    private static void executeActivity(CarDriving carDriving) {
        double distance = getDistanceInput();
        double carbonFootprint = carDriving.calculateCarbonFootprint(distance);

        System.out.println(
                "\nJejak Karbon dari " + carDriving.getClass().getSimpleName() + ": " + carbonFootprint + " gram CO2e");
    }

    private static double getDistanceInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan jarak perjalanan (km): ");
            double distance = Double.parseDouble(scanner.nextLine());

            return distance;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
