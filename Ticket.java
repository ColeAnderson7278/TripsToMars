public class Ticket {
    String spaceline;
    Integer days;
    String tripType;
    Integer price;

    public Ticket(String spaceline, Integer days, String tripType, Integer price) {
        this.spaceline = spaceline;
        this.days = days;
        this.tripType = tripType;
        this.price = price;
    }
}
