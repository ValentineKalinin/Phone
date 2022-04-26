package phone;

import exceptions.CableLengthException;

import java.util.Objects;

public class Cable {
    private String cableName;
    private int cableLength;

    public Cable() {
    }

    public Cable(String cable, int cableLength) {
        this.cableName = cable;
        this.cableLength = cableLength;
    }

    @Override
    public String toString() {
        return "Cable{" +
                "cable = '" + cableName + '\'' +
                ", cableLength = " + cableLength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cable cable1 = (Cable) o;
        return cableLength == cable1.cableLength && Objects.equals(cableName, cable1.cableName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cableName, cableLength);
    }

    public int getCableLength() {
        return cableLength;
    }

    public void setCableName(String cableName) {
        this.cableName = cableName;
    }

    public String getCableName() {
        return cableName;
    }

    public void setCableLength(int cableLength) throws CableLengthException {
        if (cableLength >= 0)
            this.cableLength = cableLength;
        else
            throw new CableLengthException("Length of Cable is incorrect");

    }
}
