import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void OrderedMarkList(){
        List<Student> studentsList=StudentUtils.getFromFile("mark_data.txt");
        Map<String,List<String>> comparisonMap= StudentUtils.computeAllComparisons(studentsList);
        Map<String,List<String>> reducedMap=StudentUtils.reduceComparisons(comparisonMap);
        StudentUtils.printComparisons(reducedMap);

    }

    public static void main(String[] args) {

        OrderedMarkList();

    }
}
