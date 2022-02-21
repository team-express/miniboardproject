package express.miniboardproject.board;

import express.miniboardproject.board.dto.BoardDTO;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository repository;

	public List<BoardDTO> getList() {
		List<Board> boards = repository.findAll();
		return boards.stream().map(BoardDTO::new).collect(Collectors.toList());
	}

	public long write(BoardDTO boardDTO) {
		Board board = new Board(boardDTO.getTitle(), boardDTO.getContent());
		return repository.save(board);
	}

	public BoardDTO getById(Long id) {
		return new BoardDTO(repository.findById(id));
	}

	public long edit(BoardDTO boardDTO) {
		Long id = boardDTO.getId();
		Board findBoard = repository.findById(id);
		return repository.save(findBoard);
	}

	public void remove(Long id) {
		repository.deleteById(id);
	}

}
