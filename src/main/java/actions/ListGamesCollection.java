package actions;

import games.Game;
import games.GameCollection;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListGamesCollection implements UserActions {
    private static final String ROW_FORMAT = "|%-4s|%-4s|%-4s|";
    private final GameCollection gameCollection;

    @Override
    public void execute() {
        System.out.println(createTopRowHeaders());

        gameCollection.findAll().stream()
                .map(game -> toLine(game))
                .forEach(game -> System.out.println(game));
    }

    private String toLine(Game game) {
        return String.format(ROW_FORMAT, "Serial", "Title", "Publisher");
    }

    private String createTopRowHeaders() {
        return String.format(ROW_FORMAT, "Serial", "Title", "Publisher");
    }
}
