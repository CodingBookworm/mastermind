package Model;

import Service.CodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class CodeServiceTest {

    @InjectMocks
    CodeService codeService;

    @Test
    public void secretDemoReturnsListOfChars(){
        assertEquals(Arrays.asList('A','B','E','D'),codeService.setCode("secret demo"));
    }

    @Test
    public void findSimilaritiesReturnsAllStarsWhenCompleteMatch(){
        List<Character> gameCode = Arrays.asList('A','B','E','D');
        List<Character> userGuess = Arrays.asList('A','B','E','D');
        List matches = codeService.findSimilaritiesBetween(gameCode,userGuess);
        assertEquals(Arrays.asList('*','*','*','*'),matches);
    }

    @Test
    public void findSimilaritiesReturnsCorrectSymbolsToMatches(){
        List<Character> gameCode = Arrays.asList('A','B','E','D');
        List<Character> userGuess = Arrays.asList('A','B','D','C');
        List matches = codeService.findSimilaritiesBetween(gameCode,userGuess);
        assertTrue(matches.contains('*'));
        assertTrue(matches.contains('^'));
        userGuess = Arrays.asList('B','A','D','C');
        matches = codeService.findSimilaritiesBetween(gameCode,userGuess);
        assertFalse(matches.contains('*'));
    }

    @Test
    public void duplicatesInCodeDontReturnTwice(){
        List<Character> gameCode = Arrays.asList('A','B','B','D');
        List<Character> userGuess = Arrays.asList('A','E','B','C');
        List matches = codeService.findSimilaritiesBetween(gameCode,userGuess);
        assertEquals(Arrays.asList('*','*',' ',' '),matches);
    }

    @Test
    public void duplicatesInGuessDontReturnTwice(){
        List<Character> gameCode = Arrays.asList('A','E','B','D');
        List<Character> userGuess = Arrays.asList('A','B','B','C');
        List matches = codeService.findSimilaritiesBetween(gameCode,userGuess);
        assertEquals(Arrays.asList('*','*',' ',' '),matches);
    }





}