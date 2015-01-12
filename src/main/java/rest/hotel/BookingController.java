package rest.hotel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private Bookings bookings = new Bookings();

    @RequestMapping(
        value = "/{bookingId}",
        method = RequestMethod.GET,
        produces = "application/x-travel.booking+json"
    )
    public ResponseEntity<Booking> booking(@PathVariable int bookingId) {
        Booking booking = bookings.findBookingById(bookingId);
        if (booking == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @RequestMapping(
        method = RequestMethod.POST,
        headers = {"Content-type=application/x-travel.booking+json"},
        produces = "application/x-travel.booking+json"
    )
    public ResponseEntity<Booking> bookRoom(@RequestBody Booking booking) {
        if (bookings.alreadyBooked(booking.getBookingId())) {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
        bookings.add(booking);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }
}
