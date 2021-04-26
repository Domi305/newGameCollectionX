package actions;


import games.GameCollection;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.StringTokenizer;

@RequiredArgsConstructor
public class ActionCreator {
    private final GameCollection gameCollection;

    public Optional<UserActions> actionsList(StringTokenizer tokenInput) {
        switch (tokenInput.nextToken()) {
            case "add": return createAddGameCollection(tokenInput);
            case "list": return Optional.of(new ListGamesCollection(gameCollection));
            case "remove" : return createRemoveGameAction(tokenInput);
            case "exit" : return Optional.of(() -> System.exit(0));
            default: return Optional.empty();
        }
    }

    /** add Game format:
     * 'add Metal-Gear-Soli-2 Konami'
     */
    private Optional<UserActions> createAddGameCollection(StringTokenizer tokenInput) {
        if (tokenInput.countTokens() != 2) {
            return Optional.empty();
        }
        String title = tokenInput.nextToken();
        String publisher = tokenInput.nextToken();
        return Optional.of(new AddGameAction(gameCollection, title.replace("-", " "), publisher));
    }

    /** remove Game by serial format:
     * 'remove #'
     */
    private Optional<UserActions> createRemoveGameAction(StringTokenizer tokenInput) {
        if (tokenInput.countTokens() !=1) {
            return Optional.empty();
        }
        int serialToDelete = Integer.parseInt(tokenInput.nextToken());
        return Optional.of(() -> gameCollection.removeBySerial(serialToDelete));
    }
}
