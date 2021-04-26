import actions.ActionCreator;
import actions.ActionsTaker;
import actions.UserActions;

import java.util.Optional;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Application {
    private ActionCreator actionCreator = new ActionCreator();
    private ActionsTaker actionsTaker = new ActionsTaker();
    private Scanner console = new Scanner(System.in);

    void executeAction() {
        displayPrompt();
            Optional<UserActions> optionalAction = actionCreator.actionsList(tokenInput());

            optionalAction
                    .ifPresentOrElse(
                    userActions -> actionsTaker.runUserAction(userActions),
                    () -> System.out.println("action not recognized")
            );
    }

    private void displayPrompt() {
        System.out.println(">");
    }

    private StringTokenizer tokenInput() {
        return new StringTokenizer(console.nextLine());
    }

    public static void main(String[] args) {
        Application application = new Application();

        while (true) {
            application.executeAction();
        }
    }
}
