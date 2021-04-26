package actions;

import games.Game;
import games.GameCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class AddGameActionTest {

    @Test
    public void shouldTestIfAddsGame(){

        //given
        GameCollection gameCollection = Mockito.mock(GameCollection.class);
        Mockito.when(gameCollection.add(Mockito.any(Game.class))).thenReturn(new Game("MGS", "Konami"));
        //when
        Game game = gameCollection.add(new Game("MGS", "Konami"));
        //then
        Assertions.assertEquals(game.getTitle(), "MGS");
        Assertions.assertEquals(game.getPublisher(), "Konami");
    }
}