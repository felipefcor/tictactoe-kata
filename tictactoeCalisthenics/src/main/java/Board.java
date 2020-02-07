import java.util.HashMap;
import java.util.Map;

public class Board {  //First class collections (wrap collections in classes)
    private Map<Cell,Movement> grid = new HashMap<>(); //Only one instance variable

    public void addPosition(Cell position, Movement movement) {
        if(this.grid.containsKey(position)) throw new RuntimeException();
        this.grid.put(position, movement);
    }

    public Response checkWinner() { //Wrap all primitives and strings
        System.out.println(Cell.FIVE);
        if (checkHorizontalWinner() || checkVerticalWinner() || checkDiagonalWinner()) return Response.YOUWIN; // Early return
        if (grid.size() == 9) return Response.DRAW;

        return Response.TURN;

    }

    private boolean checkDiagonalWinner() {
        if(grid.get(Cell.ZERO) == grid.get(Cell.FOUR) && grid.get(Cell.FOUR) == grid.get(Cell.EIGHT)) return true;
        if(grid.get(Cell.TWO) == grid.get(Cell.FOUR) && grid.get(Cell.FOUR) == grid.get(Cell.SIX)) return true;

        return false;
    }

    private boolean checkVerticalWinner() {
        if(grid.get(Cell.ZERO) == grid.get(Cell.THREE) && grid.get(Cell.THREE) == grid.get(Cell.SIX)) return true;
        if(grid.get(Cell.ONE) == grid.get(Cell.FOUR) && grid.get(Cell.FOUR) == grid.get(Cell.SEVEN)) return true;
        if(grid.get(Cell.TWO) == grid.get(Cell.FIVE) && grid.get(Cell.FIVE) == grid.get(Cell.EIGHT)) return true;

        return false;
    }

    private boolean checkHorizontalWinner(){

        if(grid.get(Cell.ZERO) == grid.get(Cell.ONE) && grid.get(Cell.ONE) == grid.get(Cell.TWO)) return true;
        if(grid.get(Cell.THREE) == grid.get(Cell.FOUR) && grid.get(Cell.FOUR) == grid.get(Cell.FIVE)) return true;
        if(grid.get(Cell.SIX) == grid.get(Cell.SEVEN) && grid.get(Cell.SEVEN) == grid.get(Cell.EIGHT)) return true;

        return false;
    }

}