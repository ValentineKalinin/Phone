package main.java.enums;

enum Store {
    STORE_CENTRE("Vera Khoruzhey 2"),
    STORE_WEST("Pobediteley 86"),
    MAIN_OFFICE("Hemiga 1");

    private final String address;

    Store(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
