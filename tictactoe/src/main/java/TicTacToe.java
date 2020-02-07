import java.util.Arrays;

public class TicTacToe {

    String lm = "O"; // Don't abbreviate //Wrap all primitives and strings
    String[] b = {"", "", "", "", "", "", "", "", ""}; //First class collections (wrap collections in classes)

    public boolean move(String move, int position) { // Wrap all primitives and strings

        boolean result;
        if (move != lm && b[position] == "") {
            lm = move;
            b[position] = move;
            result = true;

        } else { //Don’t use the ELSE keyword
            result = false;
        }
        return result;
    }

    public boolean winner() {

        for (int i = 0; i < b.length; i += 3) {
            if (b[i] == b[i + 1] && b[i + 1] == b[i + 2]) return true;
        }
        for (int i = 0; i < 3; i++) {
            if (b[i] == b[i + 3] && b[i + 3] == b[i + 6]) return true;
        }
        if (b[0] == b[4] && b[4] == b[8]) return true;
        if (b[2] == b[4] && b[4] == b[6]) return true;

        return false;

}

    public boolean draw() {
        if (!winner() && !Arrays.asList(b).contains("")) return true;
        return false;
    }
}