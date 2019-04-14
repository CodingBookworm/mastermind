package Model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

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


}