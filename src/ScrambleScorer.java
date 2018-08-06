import java.util.*;

public class ScrambleScorer {

    private static  final char BLANK ='#';

    private List<String> sowpodsList;

    private Map<Character,Integer> scoreCard = new HashMap<>();

    public ScrambleScorer(List<String> sowpodsList) {
        this.sowpodsList = sowpodsList;
    }

    private int evaluateScore(String word){
        return 0;
    }

    public List<String> getPossibleWords(List<Character> rack){
        List<String> possibleWords=new ArrayList<>();
        for(String sowpods:sowpodsList) {
            if(isValidWord(sowpods,rack)) {
                possibleWords.add(sowpods);
            }
        }
        return possibleWords;
    }

    public List<String> getPossibleWords(List<Character> rack, Map<Integer,Character> constraints){
        List<String> possibleWords=new ArrayList<>();
        for(String sowpods:sowpodsList) {
            if(isValidWord(sowpods,rack) && followsConstraint(sowpods,constraints)) {
                possibleWords.add(sowpods);
            }
        }
        return possibleWords;
    }


    private boolean isValidWord(String word, List<Character> rack){
        List<Character> usableChars = new ArrayList<>(rack);

        for(Character c : word.toCharArray()){
            if(usableChars.contains(c)){
                usableChars.remove(c);
            }else if(usableChars.contains(BLANK)){
                usableChars.remove(BLANK);
            }else{
                return false;
            }
        }

        return true;
    }

    private boolean followsConstraint(String word, Map<Integer, Character> constraints){
        for(Map.Entry<Integer, Character> entry : constraints.entrySet()){
            if(word.charAt(entry.getKey()) != entry.getValue())
                return false;
        }
        return true;
    }

    public String getBestPossibleWord(List<Character> rack){
        return new String();
    }

    public String getBestPossibleWord(List<Character> rack,Map<Integer,Character> constraints){
        return new String();
    }


}
