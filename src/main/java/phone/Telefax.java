package phone;

import exceptions.CallException;
import exceptions.MessageException;
import interfaces.service.IFax;
import interfaces.service.IPrintName;
import interfaces.service.IWorkable;

import java.util.Objects;

import static phone.Main.LOGGER;

public class Telefax extends Phone implements IFax, IWorkable {
    private String roomLocated;

    public Telefax() {
    }

    public Telefax(Battery battery, Screen screen, String model) {
        super(battery, screen, model);
    }

    public Telefax(Battery battery, Screen screen, String model, String room) {
        super(battery, screen, model);
        this.roomLocated = room;
    }

    public String getRoomLocated() {
        return roomLocated;
    }

    public void setRoomLocated(String roomLocated) {
        this.roomLocated = roomLocated;
    }

    @Override
    public String toString() {
        return "Telefax{" +
                "roomLocated='" + roomLocated + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefax)) return false;
        if (!super.equals(o)) return false;
        Telefax telefax = (Telefax) o;
        return Objects.equals(roomLocated, telefax.roomLocated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roomLocated);
    }

    @Override
    public void makeCall(Person from, Person to) throws CallException {
        if (!from.equals(to)) {
            IPrintName printName = (sc, al) -> LOGGER.info(sc + " call to " + al);
            LOGGER.info("Can't make call from " + getModel());
        } else
            throw new CallException("You can't make call from " + from.getPersonName() + " to " + to.getPersonName());
    }

    @Override
    public void SendFax(Person from, Person to, String fax) throws MessageException {
        if (!from.equals(to)) {
            IPrintName printName = (fPerson, sPerson) -> LOGGER.info(sPerson + " get fax \"" + fax + "\" from " + fPerson + " be fax");
            printName.print(from.getPersonName(), to.getPersonName());
        } else
            throw new MessageException("You can't send message from " + from.getPersonName() + " to " + to.getPersonName());
    }

    @Override
    public void workable() {
        LOGGER.info(getModel() + " is work!");
    }

    public void betterToCabinet() {
        if (!roomLocated.equals("Cabinet"))
            LOGGER.info("Please, put your fax to your cabinet");
        else LOGGER.info("Location of your fax is perfect");
    }
}
