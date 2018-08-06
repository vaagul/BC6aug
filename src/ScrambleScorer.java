import java.util.*;

public class ScrambleScorer {

    private static  final char BLANK ='#';
    private static final int[] score_of_letter = { 1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    private static final char START = 'A';
    private List<String> sowpodsList;

    private Map<Character,Integer> scoreCard = new HashMap<>();

    public ScrambleScorer(List<String> sowpodsList) {
        this.sowpodsList = sowpodsList;
    }

    private int evaluateScore(String word){
        int score=0;
        for(int i=0;i<word.length();i++) {
            score += score_of_letter[word.charAt(i)-START];
        }
        return score;
    }

    public List<String> getPossibleWords(List<Character> rack){
        List<String> possibleWords=new ArrayList<>();
        for(String sowpods:sowpodsList) {
            if(computeWordValidation(sowpods,rack) >= 0) {
                possibleWords.add(sowpods);
            }
        }
        return possibleWords;
    }

    public List<String> getPossibleWords(List<Character> rack, Map<Integer,Character> constraints){
        List<String> possibleWords=new ArrayList<>();
        for(String sowpods:sowpodsList) {
            if(computeWordValidation(sowpods,rack) >= 0 && followsConstraints(sowpods,constraints)) {
                possibleWords.add(sowpods);
            }
        }
        return possibleWords;
    }


    private int computeWordValidation(String word, List<Character> rack){
        int blankValues = 0;
        List<Character> usableChars = new ArrayList<>(rack);

        for(Character c : word.toCharArray()){
            if(usableChars.contains(c)){
                usableChars.remove(usableChars.indexOf(c));
            }else if(usableChars.contains(BLANK)){
                blankValues +=  score_of_letter[c - START];
                usableChars.remove(usableChars.indexOf(BLANK));
            }else{
                return -1;
            }
        }

        return blankValues;
    }

    private boolean followsConstraints(String word, Map<Integer, Character> constraints){
        int highestValue = 0;

        for(Map.Entry<Integer, Character> entry : constraints.entrySet())
            if(entry.getKey() > highestValue)
                highestValue = entry.getKey();

        int limit = word.length() - (highestValue + 1);

        if(limit < 0)
            return false;

        for(int i = 0; i <= limit; i++) {
            boolean flag = true;
            for (Map.Entry<Integer, Character> entry : constraints.entrySet()) {
                if (word.length() > entry.getKey())
                    if (word.charAt(entry.getKey() + i) != entry.getValue()) {
                        flag = false;
                        break;
                    }
            }

            if(flag)
                return true;
        }

        return false;
    }

    private String computeBestWordFromList(List<Character> rack, List<String> possibleWords) {
        int highestScore = 0;
        String bestWord = "";

        for(String s : possibleWords){
            int score = evaluateScore(s) - computeWordValidation(s, rack);
            if(score > highestScore){
                highestScore = score;
                bestWord = s;
            }

        }

        return bestWord;
    }

    public String getBestPossibleWord(List<Character> rack){
        List<String> possibleWords = getPossibleWords(rack);
        return computeBestWordFromList(rack, possibleWords);
    }

    public String getBestPossibleWord(List<Character> rack, Map<Integer,Character> constraints){
        List<Character> newRack = new ArrayList<>();
        newRack.addAll(rack);
        for(Map.Entry<Integer,Character> entry: constraints.entrySet()){
            char c =entry.getValue();
            newRack.add(c);
        }

        List<String> possibleWords = getPossibleWords(newRack, constraints);
        return computeBestWordFromList(newRack, possibleWords);
    }


}
