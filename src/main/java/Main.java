import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        TrainsCollection newCollection = new TrainsCollection(FileExtensions.read());
        FileExtensions.save(newCollection);
       System.out.println(newCollection.toString());
    }
}
