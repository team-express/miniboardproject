package express.miniboardproject.board.dto;

import express.miniboardproject.board.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	Long id;
	String title;
	String content;

	public BoardDTO() {
	}

	public BoardDTO(Board board) {
		this.id = board.getId();
		this.title = board.getTitle();
		this.content = board.getContent();;
	}
}
