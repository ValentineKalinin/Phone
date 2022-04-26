package phone;

import exceptions.ScreenDiagonalException;
import interfaces.service.IScreenSize;

import static phone.Main.LOGGER;

public class Screen implements IScreenSize {
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

    public void setDiagonalOfScreen(double diagonalOfScreen) throws ScreenDiagonalException {
        if (diagonalOfScreen <= 0) {
            throw new ScreenDiagonalException("Diagonal of screen is incorrect");
        }
        this.diagonalOfScreen = diagonalOfScreen;
    }

    public String getTechnologyOfScreen() {
        return technologyOfScreen;
    }

    public void setTechnologyOfScreen(String technologyOfScreen) {
        this.technologyOfScreen = technologyOfScreen;
    }

    public void setResolutionOfScreen(double verticalPixels, double horizontalPixel) throws ScreenDiagonalException {
        if ((verticalPixels + horizontalPixel) < diagonalOfScreen * 450) {
            throw new ScreenDiagonalException("Size of screen is incorrect");
        }
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
        return ("Work time of " + nameOfPerson + "'s screen on " + screenBrightness + "% brightness: " +
                (screenBrightness * 500 / capacityOfBattery) + " hours");
    }

    public double ppiOfScreen() {
        return Math.sqrt(Math.pow(horizontalPixel, 2) +
                Math.pow(verticalPixels, 2)) / diagonalOfScreen;
    }

    public String ppiOfScreen(String nameOfPerson) {
        int ppi = (int) (Math.sqrt(Math.pow(horizontalPixel, 2) +
                Math.pow(verticalPixels, 2)) / diagonalOfScreen);
        return ("Resolution of " + nameOfPerson + "'s screen: " + ppi + " pixels per inch");
    }

    @Override
    public void getScreenSize() {
        LOGGER.info("Screen size: " + horizontalPixel + " to " + verticalPixels);
    }
}
