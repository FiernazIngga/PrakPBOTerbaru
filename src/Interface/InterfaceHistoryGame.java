package Interface;

import java.util.List;
import Model.ModelHistoryGame.DataHistoryGame;

public interface InterfaceHistoryGame {
    public void insert(DataHistoryGame history);
    public void update(DataHistoryGame history);
    public void delete(int id);
    public List<DataHistoryGame> getAll();
}
