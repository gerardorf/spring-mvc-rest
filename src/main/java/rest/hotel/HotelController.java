package rest.hotel;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@RequestMapping("/hotels")
public class HotelController {
    @RequestMapping(method = RequestMethod.GET)
    public Hotels hotels() {
        Hotels hotels = findAllHotels();
        addHotelLinks(hotels);
        return hotels;
    }

    private Hotels findAllHotels() {
        return new Hotels(new Hotel(1, "Ritz", "Madrid"), new Hotel(2, "NH", "Barcelona"));
    }

    private void addHotelLinks(Hotels hotels) {
        hotels.add(linkTo(methodOn(HotelController.class).hotels()).withSelfRel());
        for (Hotel hotel : hotels.getHotels()) {
            hotel.add(linkTo(methodOn(HotelController.class).rooms(hotel.getHotelId())).withRel("rooms"));
        }
    }

    @RequestMapping(value = "/{hotelId}/rooms", method = RequestMethod.GET)
    public Rooms rooms(@PathVariable int hotelId) {
        Rooms rooms = findRoomsOfHotel(hotelId);
        addRoomLinks(rooms);
        return rooms;
    }

    private Rooms findRoomsOfHotel(int hotelId) {
        return new Rooms(hotelId, new Room(1, "single", BigDecimal.valueOf(10)), new Room(2, "double", BigDecimal.valueOf(20)));
    }

    private void addRoomLinks(Rooms rooms) {
        rooms.add(linkTo(methodOn(HotelController.class).rooms(rooms.getHotelId())).withSelfRel());
        for (Room room : rooms.getRooms()) {
            room.add(linkTo(methodOn(BookingController.class).bookRoom(new Booking(rooms.getHotelId(), room.getRoomId()))).withRel("bookings"));
        }
    }
}
