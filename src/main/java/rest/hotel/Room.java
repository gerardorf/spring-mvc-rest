package rest.hotel;

import org.springframework.hateoas.ResourceSupport;

import java.math.BigDecimal;

public class Room extends ResourceSupport {
    private int roomId;
    private String type;
    private BigDecimal price;

    public Room(int roomId, String type, BigDecimal price) {
        this.roomId = roomId;
        this.type = type;
        this.price = price;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
