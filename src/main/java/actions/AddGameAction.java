package actions;

import games.DuplicateTitleException;
import games.Game;
import games.GameCollection;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddGameAction implements UserActions{
    private final GameCollection gameCollection;
    private final String title;
    private final String publisher;

    @Override
    public void execute() {
        try {
            Game addedGame = gameCollection.add(new Game(title, publisher));
            System.out.println("Game with title " + addedGame.getTitle() + " added to collection");
        } catch (DuplicateTitleException toIgnore) {
            System.out.println(title + "  - game does exist in Collection. Try again");
        }
    }
}
