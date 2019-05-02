package Controller;

import Model.CodeService;
import View.Viewer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @Mock
    Viewer viewer;

    @Mock
    CodeService gameCodeService;

    @InjectMocks
    GameService gameService;


    @Test
    public void setCodeCallsCodeService(){
        gameService.playGame();
        verify(gameCodeService).setCode(any());
    }



}