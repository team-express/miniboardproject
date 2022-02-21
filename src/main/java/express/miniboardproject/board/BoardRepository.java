package express.miniboardproject.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository {

	private Map<Long, Board> boards = new HashMap<>();
	private long sequence = 0L;

	public long save(Board board) {
		if (board.getId() == null) {
			Board saveBoard = new Board(++sequence, board.getTitle(), board.getContent());
			boards.put(saveBoard.getId(), saveBoard);
			return saveBoard.getId();
		}
		Board findBoard = boards.replace(board.getId(), board);
		return findBoard.getId();
	}

	public List<Board> findAll() {
		return new ArrayList<>(boards.values());
	}

	public Board findById(Long id) {
		return boards.get(id);
	}

	public void deleteById(Long id) {
		boards.remove(id);
	}
}
