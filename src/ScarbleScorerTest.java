import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ScarbleScorerTest {
    private ScrambleScorer scrambleScorer;


    @Before
    public void setup(){

        List<String> sowpodsList = null;
        try {
            sowpodsList = ScrambleUtils.getWordsFromDict();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scrambleScorer = new ScrambleScorer(sowpodsList);
    }


    @Test
    public void basicTestWithoutConstraints(){
        List<Character> rack = Arrays.asList('A', 'Z', 'E', 'A', 'R', 'B', 'W');
        String bestWord = scrambleScorer.getBestPossibleWord(rack);
        Assert.assertEquals("WAREZ", bestWord);
    }

    @Test
    public void highestScoreTestWithoutConstraints(){
        List<Character> rack = Arrays.asList('M', 'J', 'K', 'I', 'U', 'Z', 'S');
        String bestWord = scrambleScorer.getBestPossibleWord(rack);
        Assert.assertEquals("MUZJIKS", bestWord);
    }

    @Test
    public void basicBlankTestWithoutConstraints(){
        List<Character> rack = Arrays.asList('A','I','Y', 'T', 'U', 'E', '#');
        String bestWord = scrambleScorer.getBestPossibleWord(rack);
        Assert.assertEquals("AUREITY", bestWord);
    }
}
