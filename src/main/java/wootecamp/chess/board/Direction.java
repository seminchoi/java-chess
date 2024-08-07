package wootecamp.chess.board;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Direction {
    NORTH(0, 1),
    NORTHEAST(1, 1),
    EAST(1, 0),
    SOUTHEAST(1, -1),
    SOUTH(0, -1),
    SOUTHWEST(-1, -1),
    WEST(-1, 0),
    NORTHWEST(-1, 1),

    NNE(1, -2),
    NNW(-1, -2),
    SSE(1, 2),
    SSW(-1, 2),
    EEN(2, 1),
    EES(2, -1),
    WWN(-2, 1),
    WWS(-2, -1);


    private final int x;
    private final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static List<Direction> linearDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST);
    }

    public static List<Direction> diagonalDirection() {
        return Arrays.asList(NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

    public static List<Direction> everyDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

    public static List<Direction> knightDirection() {
        return Arrays.asList(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
    }

    public static List<Direction> whitePawnDirection() {
        return Arrays.asList(NORTH);
    }

    public static List<Direction> blackPawnDirection() {
        return Arrays.asList(SOUTH);
    }

    public static List<Direction> whitePawnSpecificDirection() {
        return Arrays.asList(NORTHEAST, NORTHWEST);
    }

    public static List<Direction> blackPawnSpecificDirection() {
        return Arrays.asList(SOUTHEAST, SOUTHWEST);
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
