import java.util.Comparator;

public class SortingRoutines {
    public static class SortBySerial implements Comparator<Train>{
        @Override
        public int compare(Train o1, Train o2) {
            return ((Train) o1).getSerial() - ((Train) o2).getSerial();
        }
    }
}
