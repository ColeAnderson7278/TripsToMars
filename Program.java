import java.util.Random;

public class Program {
    static Ticket ticket;
    static Random rand = new Random();
    static String[] spacelines = new String[] { "Space Adventure", "Space X", "Virgin Galatic" };
    static String[] tripType = new String[] { "Round Trip", "One Way" };
    static Integer kilometersToMars = 62100000;
    static Integer secondsInDay = 86400;
    static Integer maxSpeed = 30;
    static Integer minSpeed = 16;
    static Integer maxPrice = 50;
    static Integer minPrice = 36;

    public static void main(String[] args) {
        showHeader();
        makeTickets();
    }

    private static void makeTickets() {
        for (int i = 0; i < 10; i++) {
            Integer speed = rand.nextInt((maxSpeed - minSpeed) + 1) + minSpeed;
            ticket = new Ticket(getSpaceline(), getDays(speed), getTripType(), getOneWayPrice(speed));
            updatePrice();
            System.out.printf("\n%-16s %4s %12s %8s", ticket.spaceline, ticket.days, ticket.tripType,
                    "$" + ticket.price);
        }
    }

    private static String getSpaceline() {
        Integer random = rand.nextInt(spacelines.length);
        return spacelines[random];
    }

    private static Integer getDays(Integer speed) {
        return kilometersToMars / (speed * secondsInDay);
    }

    private static String getTripType() {
        Integer random = rand.nextInt(tripType.length);
        return tripType[random];
    }

    private static Integer getOneWayPrice(Integer speed) {
        Integer oneWayPrice = rand.nextInt((maxPrice - minPrice) + 1) + minPrice;
        return oneWayPrice + (speed - 15);
    }

    private static void updatePrice() {
        if (ticket.tripType == "Round Trip") {
            ticket.price = ticket.price * 2;
        }
    }

    private static void showHeader() {
        System.out.printf("%-16s %4s %12s %8s", "Spaceline", "Days", "Trip Type", "Price");
        System.out.println("\n===========================================");
    }
}
