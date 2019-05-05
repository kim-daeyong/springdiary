package my.example.spring.diary.controller;


import my.example.spring.diary.dto.Board;
import my.example.spring.diary.service.BoardService;
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

    @GetMapping("/index")
    public String main(
            Model model) {

        return "index";
    }

    @GetMapping("/diarylist")
    public String dairyList(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            Model model) {
        List<Board> boards = boardService.selectAllBoards(page);

        model.addAttribute("boards", boards);
        return "diarylist";
    }

    @GetMapping("/calendar")
    public String calledar(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            Model model) {
        List<Board> boards = boardService.selectAllBoards(page);

        model.addAttribute("boards", boards);
        return "calendar";
    }

    @GetMapping("/view")
    public String view(
            @RequestParam(name = "id") long id,
            Model model) {
        Board board = boardService.selectBoard(id);
        model.addAttribute("board", board);
        return "read";
    }

    @GetMapping("/modify")
    public String modify(
            @RequestParam(name = "id") long id,
            Model model) {
        Board board = boardService.selectBoard(id);
        model.addAttribute("board", board);
        return "modify";
    }

    @PostMapping("/modify")
    public String modifyAction(
                              @RequestParam(name = "content") String content,
                              Model model,
                              HttpSession session) {
        Board board = new Board(content);
//        long id = boardService.addBoard(board);
        model.addAttribute("message", "글이 등록되었습니다.");

        return "redirect:diarylist";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @PostMapping("/write")
    public String writeAction(@RequestParam(name = "nickname") String nickname,
                              @RequestParam(name = "content") String content,
                              Model model,
                              HttpSession session) {
        Board board = new Board(nickname, content);
//        long id = boardService.addBoard(board);
        model.addAttribute("message", "글이 등록되었습니다.");

        return "redirect:diarylist";
    }

}