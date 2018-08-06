import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScrambleUtils {
    public static List<String> getWordsFromDict() throws IOException {
        ArrayList<String> extractedDict= new ArrayList<String>();
        File sowpods=new File("/Users/vamm/IdeaProjects/BC4aug/sowpods.txt");
        try {
            BufferedReader br= new BufferedReader(new FileReader(sowpods));
            String st;
            while ((st = br.readLine()) != null ){
                    extractedDict.add(st);
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return extractedDict;
    }

}
