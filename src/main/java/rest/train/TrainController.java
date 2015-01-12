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

    @RequestMapping(value = "/{booking}", method = RequestMethod.GET)
    public ResponseEntity<String> train(@PathVariable("booking") Integer booking) {
        String trainCode = bookings.get(booking);
        if (trainCode == null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(trainCode,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public int book(String trainCode) {
        int booking = new SecureRandom().nextInt();
        bookings.put(booking, trainCode);
        return booking;
    }

    @RequestMapping(value = "/{booking}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("booking") Integer booking, @RequestBody String trainCode) {
        bookings.put(booking, trainCode);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{booking}", method = RequestMethod.DELETE)
    public ResponseEntity cancel(@PathVariable("booking") Integer booking) {
        if (!bookings.containsKey(booking)){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        bookings.remove(booking);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
