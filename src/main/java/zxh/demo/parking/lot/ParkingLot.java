package zxh.demo.parking.lot;

import java.util.ArrayList;

/**
 * ParkingLot:
 * @author zhangxuhai
 * @date 2019/11/18
*/
public class ParkingLot {
    private ArrayList<Ticket> carContainer;
    private int size = 0;

    public ParkingLot(int size) {
        this.size = size;
        carContainer = new ArrayList<>();
    }

    public Ticket park() {
        if (size == carContainer.size()) {
            throw new ParkingLotFullException();
        }

        Ticket ticket = Ticket.create();
        carContainer.add(ticket);
        return ticket;
    }

    public Ticket pick(Ticket ticket) {
        Ticket result = carContainer
                .stream()
                .filter(t -> t.equals(ticket))
                .findAny()
                .orElseThrow(InvalidTicketException::new);
        carContainer.remove(result);
        return result;
    }
}