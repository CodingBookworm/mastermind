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


    @Test
    public void scannerReturnsListOfValues(){
//        when(scannerMock.nextLine())
//                .thenReturn("ABCD");
        assertThat(userInputController.getUserCode(), is(equalTo(Arrays.asList('A','B','C','D'))));
    }


}