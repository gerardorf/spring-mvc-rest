package hello;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

import static java.util.Arrays.asList;

public class Hotels extends ResourceSupport {
    private final List<Hotel> hotels;

    public Hotels(Hotel... hotels) {
        this.hotels = asList(hotels);
    }

    public List<Hotel> getHotels() {
        return hotels;
    }
}
