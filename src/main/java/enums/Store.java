package main.java.enums;

enum Store {
    STORE_1("Vera Khoruzhey 2"),
    STORE_2("Pobediteley 86"),
    MAIN_OFFICE("Hemiga 1");

    private final String address;

    Store(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
