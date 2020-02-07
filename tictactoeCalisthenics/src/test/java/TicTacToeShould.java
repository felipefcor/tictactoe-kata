import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TicTacToeShould {

    Tictactoe tictactoe;

    @Before
    public void setup(){
        tictactoe = new Tictactoe();
    }

    @Test
    public void doesNotAllowStartWithO() {
        Assert.assertEquals(Response.NOTYOURTURN, tictactoe.move(Movement.O, Cell.ZERO));
    }

    @Test
    public void onlyAllowAlternateMove(){
        tictactoe.move(Movement.X, Cell.TWO);

        Assert.assertEquals(Response.NOTYOURTURN, tictactoe.move(Movement.X, Cell.ZERO));
    }

    @Test(expected = RuntimeException.class)
    public void doesNotAllowToPlayOnPlayedPosition(){
        tictactoe.move(Movement.X, Cell.ZERO);
        tictactoe.move(Movement.O, Cell.ZERO);
    }

    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInARowHorizontallyInTheFirstRow(){
        tictactoe.move(Movement.X, Cell.ZERO);
        tictactoe.move(Movement.O, Cell.THREE);
        tictactoe.move(Movement.X, Cell.ONE);
        tictactoe.move(Movement.O, Cell.FOUR);

        Assert.assertEquals(Response.YOUWIN, tictactoe.move(Movement.X, Cell.TWO));
    }
    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInARowHorizontallyInTheSecondRow(){
        tictactoe.move(Movement.X, Cell.THREE);
        tictactoe.move(Movement.O, Cell.ZERO);
        tictactoe.move(Movement.X, Cell.FOUR);
        tictactoe.move(Movement.O, Cell.ONE);

        Assert.assertEquals(Response.YOUWIN, tictactoe.move(Movement.X, Cell.FIVE));
    }

    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInARowHorizontallyInTheThirdRow(){
        tictactoe.move(Movement.X, Cell.SIX);
        tictactoe.move(Movement.O, Cell.ZERO);
        tictactoe.move(Movement.X, Cell.SEVEN);
        tictactoe.move(Movement.O, Cell.ONE);

        Assert.assertEquals(Response.YOUWIN, tictactoe.move(Movement.X, Cell.EIGHT));
    }

    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInARowHorizontallyInTheFirstColumn(){
        tictactoe.move(Movement.X, Cell.ZERO);
        tictactoe.move(Movement.O, Cell.ONE);
        tictactoe.move(Movement.X, Cell.THREE);
        tictactoe.move(Movement.O, Cell.FOUR);

        Assert.assertEquals(Response.YOUWIN, tictactoe.move(Movement.X, Cell.SIX));
    }

    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInARowHorizontallyInTheSecondColumn(){
        tictactoe.move(Movement.X, Cell.ONE);
        tictactoe.move(Movement.O, Cell.ZERO);
        tictactoe.move(Movement.X, Cell.FOUR);
        tictactoe.move(Movement.O, Cell.THREE);

        Assert.assertEquals(Response.YOUWIN, tictactoe.move(Movement.X, Cell.SEVEN));
    }

    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInARowHorizontallyInTheThirdColumn(){
        tictactoe.move(Movement.X, Cell.TWO);
        tictactoe.move(Movement.O, Cell.ONE);
        tictactoe.move(Movement.X, Cell.FIVE);
        tictactoe.move(Movement.O, Cell.FOUR);

        Assert.assertEquals(Response.YOUWIN, tictactoe.move(Movement.X, Cell.EIGHT));
    }

    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInDiagonalLeftToRigthDown(){
        tictactoe.move(Movement.X, Cell.ZERO);
        tictactoe.move(Movement.O, Cell.TWO);
        tictactoe.move(Movement.X, Cell.FOUR);
        tictactoe.move(Movement.O, Cell.FIVE);

        Assert.assertEquals(Response.YOUWIN, tictactoe.move(Movement.X, Cell.EIGHT));
    }

    @Test
    public void detectWinnerWhenThereAreThreeSameMovementInDiagonalRigthToLeftDown(){
        tictactoe.move(Movement.X, Cell.TWO);
        tictactoe.move(Movement.O, Cell.ZERO);
        tictactoe.move(Movement.X, Cell.FOUR);
        tictactoe.move(Movement.O, Cell.ONE);

        Assert.assertEquals(Response.YOUWIN, tictactoe.move(Movement.X, Cell.SIX));
    }

    @Test
    public void detectDrawWhenBoardIsFilledWithoutWinner(){
        tictactoe.move(Movement.X, Cell.ZERO );
        tictactoe.move(Movement.O, Cell.ONE);
        tictactoe.move(Movement.X, Cell.TWO);
        tictactoe.move(Movement.O, Cell.THREE);
        tictactoe.move(Movement.X, Cell.FIVE);
        tictactoe.move(Movement.O, Cell.FOUR);
        tictactoe.move(Movement.X, Cell.SEVEN);
        tictactoe.move(Movement.O, Cell.EIGHT);

        Assert.assertEquals(Response.DRAW, tictactoe.move(Movement.X, Cell.SIX));
    }

}