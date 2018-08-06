import java.util.*;

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





    private static int computeNoOfComparisons(Map<String, List<String>> comparisonMap){

        int length = 0;
        for (Map.Entry<String, List<String>> entry : comparisonMap.entrySet()) {
            length += entry.getValue().size();
        }

        return length;
    }

    public static Map<String,List<String>> reduceComparisons(Map<String,List<String>> comparisonMap){
        Map<String, List<String>> current = comparisonMap;
        Map<String, List<String>> modified = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : current.entrySet()) {
            Set<String> subtractiveSet = new HashSet<>();
            List<String> additiveList = entry.getValue();
            List<String> modifiedList = new ArrayList<>();

            for(String s : additiveList){
                subtractiveSet.addAll(current.get(s));
            }

            for(String s : additiveList){
                if(!subtractiveSet.contains(s))
                    modifiedList.add(s);
            }

            modified.put(entry.getKey(), modifiedList);
        }

        return modified;
    }


    public static void printComparisons(Map<String,List<String>> comparisonMap){
        Set<Map.Entry<String,List<String>>> entries = comparisonMap.entrySet();
        for(Map.Entry<String,List<String>> entry : entries) {
            String key = entry.getKey();
            List<String> studentIds = entry.getValue();
            for(String studentId : studentIds) {
                System.out.print(studentId+">"+key+" ");
            }
            System.out.println();
        }
    }
}
