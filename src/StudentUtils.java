import java.util.*;

public class StudentUtils {
    public static Map<String,List<String>> computeAllComparisons(List<Student> studentList){
        return new HashMap<>();
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


    public static void printComparisons(Map<String,List<Student>> comparisionMap){

    }
}
