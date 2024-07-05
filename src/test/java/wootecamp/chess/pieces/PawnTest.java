package wootecamp.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import wootecamp.chess.board.Board;
import wootecamp.chess.board.BoardPosition;
import wootecamp.chess.board.MoveVector;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PawnTest {
    @Nested
    class 흰색_폰은 {
        @Test
        void 초기_위치에서_위쪽으로_두_칸_움직일_수_있다() {
            Board board = new Board();
            Piece pawn = PieceFactory.createWhitePawn();

            board.initializeEmpty();
            BoardPosition source = new BoardPosition("a2");
            board.move("a2", pawn);

            List<BoardPosition> expectMovablePositions = List.of(new BoardPosition("a3"), new BoardPosition("a4"));
            List<BoardPosition> movablePositions = pawn.findAllMovablePositions(board, source);

            assertThat(movablePositions).isEqualTo(expectMovablePositions);
        }

        @Test
        void 위쪽으로_한_칸_움직일_수_있다() {
            Board board = new Board();
            Piece pawn = PieceFactory.createWhitePawn();

            board.initializeEmpty();
            BoardPosition source = new BoardPosition("a3");
            board.move("a3", pawn);

            List<BoardPosition> expectMovablePositions = List.of(new BoardPosition("a4"));
            List<BoardPosition> movablePositions = pawn.findAllMovablePositions(board, source);

            assertThat(movablePositions).isEqualTo(expectMovablePositions);
        }

        @Test
        void 적이_앞에_있으면_한_칸_움직일_수_있다() {
            Board board = new Board();
            Piece pawn = PieceFactory.createWhitePawn();

            board.initializeEmpty();
            BoardPosition source = new BoardPosition("a3");
            board.move("a3", pawn);

            List<BoardPosition> expectMovablePositions = List.of(new BoardPosition("a4"));
            List<BoardPosition> movablePositions = pawn.findAllMovablePositions(board, source);

            assertThat(movablePositions).isEqualTo(expectMovablePositions);
        }
    }



    static Stream<Arguments> provideBlackPawnMoves() {
        return Stream.of(
                Arguments.of("b7", "b6", true),
                Arguments.of("b7", "c6", true),
                Arguments.of("b1", "c3", false),
                Arguments.of("b1", "c3", false)
        );
    }

    @ParameterizedTest(name = "{index} => source={0}, destination={1}, expected={2}")
    @MethodSource("provideBlackPawnMoves")
    @DisplayName("Test Black Pawn Moves")
    void testBlackPawnMoves(String source, String target, boolean expected) {
        Piece pawn = PieceFactory.createBlackPawn();

        BoardPosition sourcePos = new BoardPosition(source);
        BoardPosition destPos = new BoardPosition(target);
        MoveVector moveVector = new MoveVector(sourcePos, destPos);
    }
}
