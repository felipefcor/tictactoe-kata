import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TicTacToeShould {

    TicTacToe tictactoe;

    @Before
    public void setup(){
        tictactoe = new TicTacToe();
    }

    @Test
    public void doesNotAllowStartWithO() {
        Assert.assertFalse(tictactoe.move("O", 0));
    }

    @Test
    public void onlyAllowAlternateMove(){
        tictactoe.move("X", 0);

        Assert.assertFalse(tictactoe.move("X", 0));
    }

    @Test
    public void doesNotAllowToPlayOnPlayedPosition() {
        tictactoe.move("X", 1);

        Assert.assertFalse(tictactoe.move("O", 1));
    }

    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInARowHorizontallyInTheFirstRow(){
        tictactoe.move("X", 0);
        tictactoe.move("O", 3);
        tictactoe.move("X", 1);
        tictactoe.move("O", 6);
        tictactoe.move("X", 2);

        Assert.assertTrue(tictactoe.winner());
    }

    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInARowHorizontallyInTheSecondRow(){
        tictactoe.move("X",3);
        tictactoe.move("O",6);
        tictactoe.move("X",4);
        tictactoe.move("O",1);
        tictactoe.move("X",5);

        Assert.assertTrue(tictactoe.winner());
    }

    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInARowHorizontallyInTheThirdRow(){
        tictactoe.move("X",6);
        tictactoe.move("O",1);
        tictactoe.move("X",7);
        tictactoe.move("O",3);
        tictactoe.move("X",8);

        Assert.assertTrue(tictactoe.winner());
    }

    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInARowHorizontallyInTheFirstColumn(){
        tictactoe.move("X", 0);
        tictactoe.move("O", 1);
        tictactoe.move("X", 3);
        tictactoe.move("O", 4);
        tictactoe.move("X", 6);

        Assert.assertTrue(tictactoe.winner());
    }

    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInARowHorizontallyInTheSecondColumn(){
        tictactoe.move("X", 1);
        tictactoe.move("O", 0);
        tictactoe.move("X", 4);
        tictactoe.move("O", 3);
        tictactoe.move("X", 7);

        Assert.assertTrue(tictactoe.winner());
    }

    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInARowHorizontallyInTheThirdColumn(){
        tictactoe.move("X", 2);
        tictactoe.move("O", 1);
        tictactoe.move("X", 5);
        tictactoe.move("O", 4);
        tictactoe.move("X", 8);

        Assert.assertTrue(tictactoe.winner());
    }

    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInDiagonalLeftToRigthDown(){
        tictactoe.move("X", 0);
        tictactoe.move("O", 6);
        tictactoe.move("X", 4);
        tictactoe.move("O", 7);
        tictactoe.move("X", 8);

        Assert.assertTrue(tictactoe.winner());
    }

    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInDiagonalRigthToLeftDown(){
        tictactoe.move("X", 2);
        tictactoe.move("O", 0);
        tictactoe.move("X", 4);
        tictactoe.move("O", 3);
        tictactoe.move("X", 6);

        Assert.assertTrue(tictactoe.winner());
    }

    @Test
    public void detectDrawWhenBoardIsFilledWithoutWinner(){
        tictactoe.move("X",1);
        tictactoe.move("O",0);
        tictactoe.move("X",2);
        tictactoe.move("O",5);
        tictactoe.move("X",3);
        tictactoe.move("O",6);
        tictactoe.move("X",4);
        tictactoe.move("O",7);
        tictactoe.move("X",8);

        Assert.assertTrue(tictactoe.draw());
    }


}
