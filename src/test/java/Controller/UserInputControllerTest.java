package Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UserInputControllerTest {

    @InjectMocks
            UserInputController userInputController;
//
//    Scanner sc = new Scanner(System.in);

    @Test
    public void scannerReturnsListOfValues(){
//        when(scannerMock.next().charAt(0))
//                .thenReturn('A','B','C','D');
        assertThat(userInputController.getUserCode(), is(equalTo(Arrays.asList('A','B','C','D'))));
    }


}