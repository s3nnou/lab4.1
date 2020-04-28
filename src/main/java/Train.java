import java.util.Comparator;

public class Train implements Comparable<Train>{
    private Integer serial;
    private String name;
    private String arrival;
    private String departure;
    private String category;

    public int getHashKey() {
        return serial % 20;
    }

    public int getSerial() {
        return serial;
    }

    public Train(int serial, String name, String arrival, String departure, String category){
        this.serial = serial;
        this.name = name;
        this.arrival = arrival;
        this.departure = departure;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public int compareTo(Train train){
        return this.getName().compareTo(train.getName());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return ("["+serial + " " + name + " " + arrival+ " " +  departure+ " " +  category + "]");
    }
}
