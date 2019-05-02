package Model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Board {
    private List<List> rows = new ArrayList<>();
}
