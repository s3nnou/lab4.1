import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public interface MyCollection<T> {
    public void Add(Object o);

    public void ReplaceAt(Object o, int i);

    public void WipeAll();

    public void DeleteAt(int i);

    public int size();

    public Object[] ToArray(Object[] a);

    public ArrayList ToArrayList();

    public String toString();

    public Iterator<T> iterator();

    public Vector filterBy(String value);

    public ArrayList sortByComparator();

    public void showDuplicates();
}
