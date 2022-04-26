package phone;

import exceptions.CallOrMessageException;
import interfaces.service.IPrintName;
import interfaces.service.IWorkable;

import java.util.Objects;

import static phone.Main.LOGGER;

public class LandlinePhone extends Phone implements IWorkable {
    static final String operator = "BelTelecom";
    private Cable cablePhone;

    public LandlinePhone() {
    }

    public LandlinePhone(Battery battery, Screen screen, String model) {
        super(battery, screen, model);
    }

    public LandlinePhone(Battery battery, Screen screen, String model, Cable cable) {
        super(battery, screen, model);
        this.cablePhone = cable;
    }

    public static String getOperator() {
        return operator;
    }

    public Cable getCablePhone() {
        return cablePhone;
    }

    public void setCablePhone(Cable cablePhone) {
        this.cablePhone = cablePhone;
    }

    @Override
    public String toString() {
        return "LandlinePhone{" +
                "cablePhone=" + cablePhone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LandlinePhone)) return false;
        if (!super.equals(o)) return false;
        LandlinePhone that = (LandlinePhone) o;
        return Objects.equals(cablePhone, that.cablePhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cablePhone);
    }

    @Override
    public void makeCall(Person from, Person to) throws CallOrMessageException {
        if (!from.equals(to)) {
            IPrintName printName = (sc, al) -> LOGGER.info(sc + " call to " + al);
            printName.print(from.getPersonName(), to.getPersonName());
        } else
            throw new CallOrMessageException("You can't make call from " + from.getPersonName() + " to " + to.getPersonName());
    }

    @Override
    public void workable() {
        System.out.println(getModel() + " is work!");
    }

    public String isCableTooLong() {
        if (cablePhone.getCableLength() >= 2)
            return "Cable is long";
        else if (cablePhone.getCableLength() <= 0)
            return "Error, long is less zero";
        else return "Cable is short";
    }
}
