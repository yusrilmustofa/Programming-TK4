package TK4;

import java.util.Scanner;

public class no1B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih aktivitas (1: Mengendarai Mobil, 2: Mengayuh Sepeda): ");
        int choice = Integer.parseInt(scanner.nextLine());

        // Penggunaan Switch Enhancement
        Activity activity = switch (choice) {
            case 1 -> new CarDriving();
            case 2 -> new Biking();
            default -> throw new IllegalArgumentException("Pilihan tidak valid.");
        };

        // Penggunaan Pencocokan Pola dengan instanceof
        if (activity instanceof CarDriving carDriving) {
            carDriving.displayInfo(() -> carDriving.openDoor());
        } else if (activity instanceof Biking biking) {
            biking.displayInfo(() -> biking.pumpTires());
        } else {
            System.out.println("Aktivitas umum.");
        }

        double distance = getDistanceInput();
        double carbonFootprint = activity.calculateCarbonFootprint(distance);

        // Penggunaan Records untuk menampilkan data
        System.out.println("\nJejak Karbon dari " + activity.name() + ": " + carbonFootprint + " gram CO2e");
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
