import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<ScrambleScorer> getPossibleWords(List<Character> rack){
        return new ArrayList<>();
    }

    public List<ScrambleScorer> getPossibleWprds(List<Character> rack, Map<Integer,Character> constraints){
        return new ArrayList<>();
    }


    private boolean isValidWord(String word, List<Character> rack){
        return true;
    }

    public String getBestPossibleWord(List<Character> rack){
        return new String();
    }

    public String getBestPossibleWord(List<Character> rack,Map<Integer,Character> constraints){
        return new String();
    }


}
