package my.example.spring.board.springboard.controller;


import my.example.spring.board.springboard.dto.Board;
import my.example.spring.board.springboard.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {
    BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String main(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            Model model) {
        List<Board> boards = boardService.selectAllBoards(page);

        model.addAttribute("boards", boards);
        return "/diarylist";
    }

    @GetMapping("/view")
    public String view(
            @RequestParam(name = "id") long id,
            Model model) {
        Board board = boardService.selectBoard(id);
        boardService.updateReadCount(id);
        model.addAttribute("board", board);
        return "/read";
    }

    @GetMapping("/modify")
    public String modify(
            @RequestParam(name = "id") long id,
            Model model) {
        Board board = boardService.selectBoard(id);
        model.addAttribute("board", board);
        return "/modify";
    }

    @GetMapping("/write")
    public String write() {
        return "/write";
    }

    @PostMapping("/write")
    public String writeAction(@RequestParam(name = "title") String title,
                              @RequestParam(name = "nickname") String nickname,
                              @RequestParam(name = "content") String content,
                              Model model,
                              HttpSession session) {
        Board board = new Board(title, nickname, content);
        long id = boardService.addBoard(board);
        model.addAttribute("message", "글이 등록되었습니다.");

        return "redirect:list";
    }

}