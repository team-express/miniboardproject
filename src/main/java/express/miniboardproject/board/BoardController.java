package express.miniboardproject.board;

import express.miniboardproject.board.dto.BoardDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	@GetMapping("/list")
	public String List(Model model) {
		List<BoardDTO> list = boardService.getList();
		model.addAttribute("list", list);
		return "list";
	}

	@GetMapping("/write")
	public String write() {
		return "write";
	}

	@PostMapping("/write")
	public String write(@ModelAttribute BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
		log.info("boardDTO={}", boardDTO);
		long boardId = boardService.write(boardDTO);
		redirectAttributes.addAttribute("boardId", boardId);
		return "redirect:/read/{boardId}";
	}

	@GetMapping("/read/{boardId}")
	public String read(@PathVariable Long boardId, Model model) {
		BoardDTO boardDTO = boardService.getById(boardId);
		model.addAttribute("dto", boardDTO);
		return "read";
	}

	@GetMapping("/edit/{boardId}")
	public String edit(@PathVariable Long boardId, Model model) {
		BoardDTO boardDTO = boardService.getById(boardId);
		model.addAttribute("dto", boardDTO);
		return "edit";
	}

	@PostMapping("/edit/{boardId}")
	public String edit(@PathVariable Long boardId, @ModelAttribute BoardDTO boardDTO) {
		boardDTO.setId(boardId);
		log.info("boardDTO={}",boardDTO);
		boardService.edit(boardDTO);
		return "redirect:/read/{boardId}";
	}

	@PostMapping("/remove/{boardId}")
	public String remove(@PathVariable Long boardId) {
		boardService.remove(boardId);
		return "redirect:/list";
	}
}
