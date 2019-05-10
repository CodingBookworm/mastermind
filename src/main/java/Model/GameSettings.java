package Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameSettings {
    private String gameMode;
    private Integer noOfRounds;
    private Boolean duplicatesAllowed;

}
