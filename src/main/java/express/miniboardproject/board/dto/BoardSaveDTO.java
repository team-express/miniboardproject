package express.miniboardproject.board.dto;

import express.miniboardproject.board.Board;

public class BoardSaveDTO {
	String title;
	String content;

	public BoardSaveDTO(Board board) {
		this.title = board.getTitle();
		this.content = board.getContent();
	}

}
