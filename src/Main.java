import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class Main {

    public static void OrderedMarkList(){
        List<Student> studentsList=StudentUtils.getFromFile("mark_data.txt");
        Map<String,List<String>> comparisonMap= StudentUtils.computeAllComparisons(studentsList);
        Map<String,List<String>> reducedMap=StudentUtils.reduceComparisons(comparisonMap);
        StudentUtils.printComparisons(reducedMap);

    }

    public static void main(String[] args) throws IOException {

        //OrderedMarkList();
        List<Character> rack=Arrays.asList(new Character[]{'A','Z','E','A','R','B','#'});
        List<String> sowpods=new ArrayList<>();
        sowpods=ScrambleUtils.getWordsFromDict();
        ScrambleScorer scrambleScorer=new ScrambleScorer(sowpods);
        System.out.println(scrambleScorer.getBestPossibleWord(rack));
        Map<Integer,Character> constrains = new HashMap<>();
        constrains.put(0,'A');
        constrains.put(2,'S');
        System.out.println(scrambleScorer.getBestPossibleWord(rack,constrains));

    }
}
