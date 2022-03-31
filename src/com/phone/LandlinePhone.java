package com.phone;

public class LandlinePhone extends Phone implements Work {
    private Cable cable = new Cable("Cable", 5);

    public LandlinePhone() {
    }

    public LandlinePhone(Battery battery, Screen screen, String model) {
        super(battery, screen, model);
    }

    @Override
    public String toString() {
        return "LandlinePhone{" +
                "cable = " + cable +
                '}';
    }

    @Override
    public void makeCall(Person from, Person to) {
        System.out.println(from.getPersonName() + " call to landline of " + to.getPersonName());
    }

    @Override
    public void workable(){
        System.out.println(getModel() + " is work!");
    }
}
