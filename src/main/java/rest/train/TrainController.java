package rest.train;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.*;

@RestController
@RequestMapping("/trains")
public class TrainController {
    private Map<Integer, String> bookings = new HashMap<>();

    @RequestMapping(method = RequestMethod.GET)
    public Map<Integer, String> trains() {
        return bookings;
    }

    @RequestMapping(value = "/{bookingId}", method = RequestMethod.GET)
    public ResponseEntity<String> train(@PathVariable Integer bookingId) {
        String trainCode = bookings.get(bookingId);
        if (trainCode == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(trainCode, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public int book(String trainCode) {
        int booking = new SecureRandom().nextInt();
        bookings.put(booking, trainCode);
        return booking;
    }

    @RequestMapping(value = "/{bookingId}", method = RequestMethod.PUT)
    public ResponseEntity update(
        @PathVariable Integer bookingId,
        @RequestBody String trainCode
    ) {
        bookings.put(bookingId, trainCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{bookingId}", method = RequestMethod.DELETE)
    public ResponseEntity cancel(@PathVariable Integer bookingId) {
        if (!bookings.containsKey(bookingId)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bookings.remove(bookingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
