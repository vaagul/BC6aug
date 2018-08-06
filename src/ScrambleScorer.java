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
        return 0;
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
