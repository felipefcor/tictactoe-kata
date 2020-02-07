enum Movement { X, O };
enum Response { NOTYOURTURN, TURN, YOUWIN, DRAW };
//Wrap all primitives and strings

public class Tictactoe {

    private Movement lastMove = Movement.O; //Don't abbreviate
    private Board board = new Board(); //No classes with more than two instance variables

    public Response move(Movement movement, Cell position) { //Wrap all primitives and strings
        if(movement == lastMove) return Response.NOTYOURTURN; //early return to keep away ELSE
        board.addPosition(position, movement); //Only one dot per line
        lastMove = movement;
        return board.checkWinner();

    }
}