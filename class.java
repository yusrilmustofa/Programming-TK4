package TK4;

class Activity {
    private String name;
    private double carbonFactor;

    public Activity(String name, double carbonFactor) {
        this.name = name;
        this.carbonFactor = carbonFactor;
    }

    public void displayInfo() {
        System.out.println("Aktivitas: " + name);
        System.out.println("Faktor Emisi: " + carbonFactor);
    }

    public double calculateCarbonFootprint(double distance) {
        return distance * carbonFactor;
    }

    public void displayInfo(Runnable displayFunction) {
        displayFunction.run();
    }

    // Method Overriding dengan menggunakan Method Reference
    public void displayInfo(DisplayInfoFunction displayFunction) {
        displayFunction.displayInfo();
    }

    public String name() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'name'");
    }

}

class CarDriving extends Activity {
    public CarDriving() {
        super("Mengendarai Mobil", 0.2);
    }

    public void openDoor() {
        System.out.println("Mobil dengan pintu sedang dibuka.");
    }

    // Method Overriding untuk displayInfo
    @Override
    public void displayInfo(DisplayInfoFunction displayFunction) {
        // Menggunakan Method Reference untuk menyederhanakan pemanggilan displayInfo
        displayFunction.displayInfo();
        // Tambahan informasi khusus untuk CarDriving
        System.out.println("Aktivitas khusus mengendarai mobil.");
    }
}

class Biking extends Activity {
    public Biking() {
        super("Mengayuh Sepeda", 0.02);
    }

    public void pumpTires() {
        System.out.println("Ban sepeda sedang dipompa.");
    }

    // Method Overriding untuk displayInfo
    @Override
    public void displayInfo(DisplayInfoFunction displayFunction) {
        // Menggunakan Method Reference untuk menyederhanakan pemanggilan displayInfo
        displayFunction.displayInfo();
        // Tambahan informasi khusus untuk Biking
        System.out.println("Aktivitas khusus mengayuh sepeda.");
    }
}

// Interface untuk fungsi displayInfo
interface DisplayInfoFunction {
    void displayInfo();
}