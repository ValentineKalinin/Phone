package com.phone;

public class Screen {
    private double diagonalOfScreen;
    private String technologyOfScreen;
    private double horizontalPixel;
    private double verticalPixels;

    public Screen() {
    }

    public Screen(double diagonalOfScreen, String technologyOfScreen) {
        this.diagonalOfScreen = diagonalOfScreen;
        this.technologyOfScreen = technologyOfScreen;
    }

    public double getDiagonalOfScreen() {
        return diagonalOfScreen;
    }

    public void setDiagonalOfScreen(double diagonalOfScreen) {
        this.diagonalOfScreen = diagonalOfScreen;
    }

    public String getTechnologyOfScreen() {
        return technologyOfScreen;
    }

    public void setTechnologyOfScreen(String technologyOfScreen) {
        this.technologyOfScreen = technologyOfScreen;
    }

    public void setResolutionOfScreen(double verticalPixels, double horizontalPixel) {
        this.verticalPixels = verticalPixels;
        this.horizontalPixel = horizontalPixel;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "diagonalOfScreen=" + diagonalOfScreen +
                ", technologyOfScreen='" + technologyOfScreen + '\'' +
                ", horizontalPixel=" + horizontalPixel +
                ", verticalPixels=" + verticalPixels +
                '}';
    }

    public String workTime(String nameOfPerson, int capacityOfBattery) {
        int screenBrightness = (int) (Math.random() * 100);
        return ("Work time of " + nameOfPerson + "'s screen on " + (int) screenBrightness + "% brightness: " +
                (screenBrightness * 500 / capacityOfBattery) + " hours");
    }

    public String ppiOfScreen(String nameOfPerson) {
        int ppi = (int) (Math.sqrt(Math.pow(horizontalPixel, 2) +
                Math.pow(verticalPixels, 2)) / diagonalOfScreen);
        return ("Resolution of " + nameOfPerson + "'s screen: " + ppi + " pixels per inch");
    }

    public void screenSize(){
        System.out.println("Screen!");
    }
}
