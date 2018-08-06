import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentUtils {
    public static Map<String,List<String>> computeAllComparisons(List<Student> studentList){
        return new HashMap<>();
    }


    public static Map<String,List<String>> reduceComparisons(Map<String,List<Student>> comparisionMap){
        return new HashMap<>();
    }


    public static void printComparisons(Map<String,List<String>> comparisionMap){
        Set<Entry<String,List<Student>>> entries = comparisonMap.entrySet();
        for(Entry<String,List<String>> entry : entries) {
            String key = entry.getKey();
            List<String> studentIds = entry.getValue();
            for(String studentId : studentIds) {
                System.out.print(studentId+">"+key+" ");
            }
        System.out.println();
        }
    }
}
