package enums;

public enum PhoneBrands {
    APPLE("Apple"), SAMSUNG("Samsung"),
    XIAOMI("Xiaomi"), HUAWEI("Huawei"), OTHER("Other");

    private final String brand;

    PhoneBrands(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}