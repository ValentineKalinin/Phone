package phone;

import java.util.Objects;

public class Cable {
    private String oneCable;
    private int cableLength;

    public Cable() {
    }

    public Cable(String cable, int cableLength) {
        this.oneCable = cable;
        this.cableLength = cableLength;
    }

    @Override
    public String toString() {
        return "Cable{" +
                "cable = '" + oneCable + '\'' +
                ", cableLength = " + cableLength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cable cable1 = (Cable) o;
        return cableLength == cable1.cableLength && Objects.equals(oneCable, cable1.oneCable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oneCable, cableLength);
    }

    public int getCableLength() {
        return cableLength;
    }

    public void setOneCable(String oneCable) {
        this.oneCable = oneCable;
    }

    public String getOneCable() {
        return oneCable;
    }

    public void setCableLength(int cableLength) {
        this.cableLength = cableLength;
    }
}
