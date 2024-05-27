package controller.board;

import data.service.ReBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BoardWriteController {
    @Autowired
    private ReBoardService boardService;
}
