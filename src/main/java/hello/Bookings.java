package hello;

import java.util.ArrayList;
import java.util.List;

public class Bookings {
    private List<Booking> bookings = new ArrayList<>();

    public boolean alreadyBooked(Integer bookingId) {
        return findBookingById(bookingId) != null;
    }

    public Booking findBookingById(Integer bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                return booking;
            }
        }
        return null;
    }

    public void add(Booking booking) {
        booking.assignId();
        bookings.add(booking);
    }
}
