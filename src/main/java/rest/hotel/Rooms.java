package rest.hotel;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

import static java.util.Arrays.asList;

public class Rooms extends ResourceSupport {
    private final int hotelId;
    private final List<Room> rooms;

    public Rooms(int hotelId, Room... rooms) {
        this.hotelId = hotelId;
        this.rooms = asList(rooms);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public int getHotelId() {
        return hotelId;
    }
}
