import java.util.ArrayList;
import java.util.*;


public class TrainsCollection<T> implements MyCollection{
    private Vector _vector;
    private Vector _duplicate;
    private int _size;

    TrainsCollection(T[] args){
        _vector = new Vector(20,1);
        _size = _vector.size();
        int i = 0;
        for (Object item : Arrays.asList(args)) {
            _vector.insertElementAt(item,i);
            i++;
            _size++;
        }
    }

    TrainsCollection(){
        _vector =  new Vector(20,1);
        _size = 0;
    }

    @Override
    public void Add(Object o) {
        if(o instanceof Train){
            int i = ((Train) o).getHashKey();

            if((_vector.size() < i) || (i < 0)){
                throw new NullPointerException("demo");
            }
            else{
                Object o1 = _vector.elementAt(i - 1);

                if(((Train)o1).getHashKey() != i) {
                    _vector.insertElementAt(o,i);
                    _size++;
                }
                else{
                    _duplicate.add(o);
                }
            }
        }
        else {
            throw new NullPointerException("demo");
        }
    }

    @Override
    public void ReplaceAt(Object o, int i) {
        if ((0 <= i) && (_vector.size() >= i)){
            _vector.setElementAt(o, i -1);
        }
        else{
            throw new NegativeArraySizeException();
        }
    }

    @Override
    public void WipeAll() {
        _vector.clear();
    }

    @Override
    public void DeleteAt(int i) {
        if ((0 <= i) && (_vector.size() >= i)){
            _vector.remove(i -1);
            _size --;
        }

    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public Object[] ToArray(Object[] a) {
        return _vector.toArray(a);
    }

    @Override
    public ArrayList ToArrayList(){
        ArrayList list = new ArrayList();
        for (Object item : _vector){
            list.add(item);
        }
        return list;
    }

    @Override
    public String toString() {
        ArrayList text = new ArrayList();
        String joinedString = null;
        for (Object item : _vector){
            joinedString = String.join("  ", ((Train)item).toString());
            text.add(joinedString);
        }

        return  text.toString();
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return  currentIndex < _vector.size() && _vector.elementAt(currentIndex) != null;
            }

            @Override
            public T next() {
                return (T) _vector.elementAt(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public Vector filterBy(String value) {
        Vector newVector = new Vector();
        for (Object item : _vector){
            if(((Train)item).getCategory() == value){
                newVector.add(item);
            }
        }

        if(newVector.size() == 0){
            return null;
        }
        else{
            return newVector;
        }
    }

    @Override
    public ArrayList sortByComparator(){
        ArrayList newArray = new ArrayList();

        for (Object item : _vector){
            newArray.add((Train)item);
        }

        Collections.sort(newArray, new SortingRoutines.SortBySerial());

        return newArray;
    }

    @Override
    public void showDuplicates(){
        _duplicate.forEach(v->System.out.print(v + ";"));
    }
}
