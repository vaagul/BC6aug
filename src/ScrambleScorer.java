import java.util.*;

public class ScrambleScorer {

    private static  final char BLANK ='#';

    private List<String> sowpodsList;

    private Map<Character,Integer> scoreCard = new HashMap<>();

    public ScrambleScorer(List<String> sowpodsList) {
        this.sowpodsList = sowpodsList;
    }

    private int evaluateScore(String word){
        final int[] score_of_letter = { 1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
        word.toLowerCase();
        int score=0;
        for(int i=0;i<word.length();i++) {
            score += score_of_letter[(int)(word.charAt(i)-'a')];
        }
        return score;
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
        List<String> possibleWords = getPossibleWords(rack);
        int highestScore = 0;
        String bestWord = "";

        for(String s : possibleWords){
            int score = evaluateScore(s);
            if(score > highestScore){
                highestScore = score;
                bestWord = s;
            }

        }

        return bestWord;
    }

    public String getBestPossibleWord(List<Character> rack, Map<Integer,Character> constraints){
        return new String();
    }


}
