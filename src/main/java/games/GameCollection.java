package games;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameCollection {

    private Map<Integer, Game> games = new HashMap<>();
    private SerialProvider serialProvider = new SerialProvider();

    public Game add(Game game) throws DuplicateTitleException {
        int serial = serialProvider.nextSerial();
        Game gameWithSerial = withSerial(serial, game);
        games.put(serial, gameWithSerial);
        return gameWithSerial;

    }

    private Game withSerial(int serial, final Game game) {
        return new Game(serial, game.getTitle(), game.getPublisher());
    }

    public List<Game> findAll() {
        return new ArrayList<>(games.values());
    }

    public void removeBySerial(int serial) {
        games.remove(serial);
    }

    private static class SerialProvider {
        private int nextUniqueSerial = 0;

        int nextSerial() {
            return nextUniqueSerial++;
        }
    }
}
