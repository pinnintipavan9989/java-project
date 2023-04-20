import java.io.Serializable;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String source;
    private String destination;
    private String date;
    private String passengers;
    private String train;
    private String className;
    
    public Ticket(String source, String destination, String date, String passengers, String train, String className) {
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.train=train;
        this.className=className;
        this.passengers=passengers;
    }
    
    public String getSource() {
        return source;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getTrain() {
        return train;
    }
    
    public String getPassengers() {
        return passengers;
    }

    
    @Override
    public String toString() {
        return "Ticket Details:\n" +
               "Source: " + source + "\n" +
               "Destination: " + destination + "\n" +
               "Date: " + date + "\n" +
               "Train: " + train + "\n" +
               "Number of Passengers: " + passengers + "\n" +
               "Class Name " + className;
    }
}
