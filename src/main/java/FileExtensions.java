import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class FileExtensions {
    public static Object[] read() throws IOException {
        ArrayList result = new ArrayList();

        FileReader fr=new FileReader("data.txt");
        BufferedReader br=new BufferedReader(fr);
        String line="";
        String[] arrs=null;
        int num=0;
        while ((line=br.readLine())!=null) {
            arrs=line.split(",");

           result.add(new Train(Integer.valueOf(arrs[0]), arrs[1], arrs[2], arrs[3], arrs[4]));

        }
        br.close();
        fr.close();

        return result.toArray();
    }

    public static void save(TrainsCollection collection) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("dataout.txt"));
        Iterator iter = collection.iterator();

        while (iter.hasNext()) {
            pw.println(iter.next());
        }

        pw.close();
    }
}
