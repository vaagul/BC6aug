import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {



    public static List<Student> getFromFile(String fname){
        String line;
        List<Student> StudentList=new ArrayList<>();

        try {
                InputStream fis = new FileInputStream("mark_data.txt");
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr);


            while ((line = br.readLine()) != null) {
                List<Integer> markList = new ArrayList<>();
                String[] words = line.split(" ");
                //student.setStudentId(words[0]);
                for(int i=1;i<words.length;i++){
                    markList.add(Integer.parseInt(words[i]));
                }
                Student student=new Student(words[0],markList);
                StudentList.add(student);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return StudentList;
    }
    public static void main(String[] args) {
        List<Student> studentsList=getFromFile("mark_data.txt");
        Map<String,List<String>> comparisonMap= StudentUtils.computeAllComparisons(studentsList);

        //System.out.println("Hello World!");
    }
}
