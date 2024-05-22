package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.service.MemberService;

@Controller
@RequiredArgsConstructor
public class MemberDetailController {
	
	@NonNull
	private MemberService memberService;
	
	@GetMapping("/member/detail")
	public String detail(@RequestParam int num)
	{
		return "member/detailpage";
	}
}