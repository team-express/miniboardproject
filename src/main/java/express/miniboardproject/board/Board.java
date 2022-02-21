package express.miniboardproject.board;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Board {
	Long id;
	String title;
	String content;

	public Board() {
	}

	public Board(Long id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
