package main;

import java.util.Objects;

public class Cable {
    private String cable;
    private int cableLength;

    public Cable() {
    }

    public Cable(String cable, int cableLength) {
        this.cable = cable;
        this.cableLength = cableLength;
    }

    @Override
    public String toString() {
        return "Cable{" +
                "cable = '" + cable + '\'' +
                ", cableLength = " + cableLength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cable cable1 = (Cable) o;
        return cableLength == cable1.cableLength && Objects.equals(cable, cable1.cable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cable, cableLength);
    }

    public int getCableLength() {
        return cableLength;
    }

    public void setCable(String cable) {
        this.cable = cable;
    }

    public String getCable() {
        return cable;
    }

    public void setCableLength(int cableLength) {
        this.cableLength = cableLength;
    }
}
