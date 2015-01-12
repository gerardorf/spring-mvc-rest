package rest.hotel;

import java.security.SecureRandom;

public class Booking {
    private int hotelId;
    private int roomId;
    private Integer bookingId;

    public Booking () {}

    public Booking(int hotelId, int roomId) {
        this.hotelId = hotelId;
        this.roomId = roomId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void assignId() {
        bookingId = new SecureRandom().nextInt();
    }
}
