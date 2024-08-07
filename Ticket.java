public class Ticket {
    private String flightNumber;
    private String departure;
    private String arrival;
    private String departureTime;
    private double price;
    private String customerName;
    private String customerEmail;
    private String seatPosition;

    public Ticket(String flightNumber, String departure, String arrival, String departureTime, double price, String customerName, String customerEmail,String seatPosition) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.price = price;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.seatPosition = seatPosition;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getseatPosition() {
        return seatPosition;
    }

    public void setseatPosition(String seatposition) {
        this.seatPosition = seatposition;
    }

    public static boolean validateFlightNumber(String flightNumber) {
        String regex = "^AA\\d{3}$";
        return flightNumber.matches(regex);
    }

    public static boolean validateDate(String date) {
        String regex = "^\\d{4}/\\d{2}/\\d{2}$";
        return date.matches(regex);
    }

    public static boolean validateTime(String time) {
        String regex = "^\\d{2}:\\d{2}$";
        return time.matches(regex);
    }

    public static boolean validateSeatPosition(String seatPosition) {
        String regex = "^[A-Z]{1}\\d{2}$";
        return seatPosition.matches(regex);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", price=" + price +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }


}
