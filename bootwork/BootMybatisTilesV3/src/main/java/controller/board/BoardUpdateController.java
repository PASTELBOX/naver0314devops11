package controller.board;

import data.service.ReBoardService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardUpdateController {

    @NonNull
    private ReBoardService boardService;

    @GetMapping("/updateform")
    public String updateForm()
    {
        return "board/updateform";
    }

    @PostMapping("/update")
    public String update()
    {
        return "redirect:./detail?num=";
    }
}
