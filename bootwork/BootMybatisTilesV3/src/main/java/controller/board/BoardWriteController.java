package controller.board;

import data.service.MemberService;
import data.service.ReBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardWriteController {
    @Autowired
    private ReBoardService boardService;

    @Autowired
    private MemberService memberService;

    @GetMapping("/form")
    public String form(
            //새글일 경우 null 값들이 넘어오므로 초기값을 지정한다
            //답글일 경우는 원글이 갖고 있는 각종 정보가 넘어온다
            @RequestParam(defaultValue = "0") int num,
            @RequestParam(defaultValue = "0") int regroup,
            @RequestParam(defaultValue = "0") int restep,
            @RequestParam(defaultValue = "0") int relevel,
            @RequestParam(defaultValue = "1") int currentPage,
            Model model
    )
    {
        //답글일 경우 제목을 얻어서 model에 저장한다
        String subject="";
        if(num>0){
            subject="[답글]"+boardService.getData(num).getSubject();
        }
        model.addAttribute("num",num);
        model.addAttribute("regroup",regroup);
        model.addAttribute("restep",restep);
        model.addAttribute("relevel",relevel);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("subject",subject);

        return "board/writeform";
    }
}
