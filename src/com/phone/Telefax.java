package com.phone;

interface Fax {
    void SendFax(Person from, Person to, String fax);
}

public class Telefax extends Phone implements Fax, Work {
    private String isSomeoneCall = "No";

    public Telefax() {
    }

    public Telefax(Battery battery, Screen screen, String model) {
        super(battery, screen, model);
    }

    @Override
    public String toString() {
        return "Telefax{" +
                "isSomeoneCall='" + isSomeoneCall + '\'' +
                '}';
    }

    @Override
    public void makeCall(Person from, Person to) {
        System.out.println("Can't make call");
    }

    @Override
    public void SendFax(Person from, Person to, String fax) {
        System.out.println(to.getPersonName() + " get fax \"" + fax + "\" from " + from.getPersonName());
    }

    @Override
    public void workable() {
        System.out.println(getModel() + " is work!");
    }
}
