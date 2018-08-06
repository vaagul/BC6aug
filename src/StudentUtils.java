import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentUtils {
    public static Map<String,List<String>> computeAllComparisons(List<Student> studentList){
        Map<String,List<String>> comparisonMap= new HashMap<>();
        List<String> singleList = new ArrayList<>();
        for(int i=0;i<studentList.size();i++){
            for(int j=0;j<studentList.size();j++){
                if(studentList.get(i).compareTo(studentList.get(j)) == 1){
                    singleList.add(studentList.get(j).getStudentId());
                }
            }
            comparisonMap.put(studentList.get(i).getStudentId(),singleList);
            singleList.clear();
        }
        return comparisonMap;
    }

    @Test
    public static void testSOmething(){

    }

    public static Map<String,List<String>> reduceComparisons(Map<String,List<Student>> comparisonMap){
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
